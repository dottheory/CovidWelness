package com.app.covidwelness.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.app.covidwelness.R
import com.app.covidwelness.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var registerClickListener: RegisterClickListener
    private  val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)
        _binding?.apply {
            buttonRegister?.setOnClickListener {
                registerClickListener.onRegisterClick()
            }

            buttonLogin?.setOnClickListener {
                loginViewModel.validateUser(editEmail.editText?.text.toString(),editPassword.editText?.text.toString())
            }
        }
        loginViewModel.loginStatus.observe(viewLifecycleOwner){
            when(it){
                1->onSuccess()
                0->showToast("Login Failed")
            }
        }    }

    private fun showToast(msg:String){
        Toast.makeText(activity,msg, Toast.LENGTH_LONG).show()
    }

    private fun onSuccess(){
       val intent: Intent = Intent(activity,HomeActivity::class.java)
        startActivity(intent)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }



     fun setRegisterListener(registerClickListener: RegisterClickListener) {
        this.registerClickListener = registerClickListener
    }


    interface RegisterClickListener {
        fun onRegisterClick()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onDestroy() {
        super.onDestroy()
    }

}