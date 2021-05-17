package com.app.covidwelness.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.app.covidwelness.databinding.ActivityLoginSignUpBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginSignUpActivity : AppCompatActivity(),LoginFragment.RegisterClickListener,SignUpFragment.LoginListener {


    private lateinit var binding: ActivityLoginSignUpBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadLoginFragment()
    }


    private fun loadLoginFragment(){
        loadFragment(LoginFragment())
    }
    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        if(childFragment is LoginFragment){
            childFragment.setRegisterListener(this)
        }else if(childFragment is SignUpFragment){
            childFragment.setLoginListener(this)
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, fragment)
            .commit();
    }

    private fun loadRegisterFragment(){
        loadFragment(SignUpFragment())
    }
    override fun onRegisterClick() {
        loadRegisterFragment()
    }

    override fun onSignUpComplete() {
        loadLoginFragment()
    }

}