package com.app.covidwelness.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.app.covidwelness.R
import com.app.covidwelness.databinding.FragmentLoginBinding
import com.app.covidwelness.databinding.FragmentSignUpBinding
import com.app.covidwelness.room.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment: Fragment(R.layout.fragment_sign_up) {


    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var loginListener: SignUpFragment.LoginListener
    private  val loginViewModel by viewModels<LoginViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignUpBinding.bind(view)
        _binding?.apply {
            buttonRegister?.setOnClickListener {
                loginViewModel.insertUser(User(editName.editText?.text.toString(),editEmail.editText?.text.toString(),editPassword.editText?.text.toString()))
            }
        }
        loginViewModel.insertStatus.observe(viewLifecycleOwner){
             when(it){
                 1->onSucess()
             }
        }
    }

    private fun  onSucess(){
        showToast("sucesss")
        loginListener.onSignUpComplete()
    }

    private fun showToast(msg:String){
         Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
    }
    fun setLoginListener(loginListener: SignUpFragment.LoginListener) {
        this.loginListener = loginListener
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    interface LoginListener {
        fun onSignUpComplete()
    }
}