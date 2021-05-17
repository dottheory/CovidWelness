package com.app.covidwelness.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.covidwelness.room.DataRepository
import com.app.covidwelness.room.User
import com.app.covidwelness.util.OnConfigurationListener


class LoginViewModel @ViewModelInject constructor(private val repository: DataRepository)  : ViewModel(){

    val insertStatus = MutableLiveData<Int>()
    val loginStatus = MutableLiveData<Int>()


    public fun insertUser(user: User){
        repository.insertUser(user, object : OnConfigurationListener {
            override fun onSuccess() {
                insertStatus.postValue(1)
            }

            override fun onSuccess(users: List<User>) {
                TODO("Not yet implemented")
            }

            override fun onError(it: Throwable) {
                insertStatus.postValue(0)
            }

        })
    }
    public fun validateUser(userName: String,password :String){
        repository.getAllUsers( object : OnConfigurationListener {
            override fun onSuccess() {
                loginStatus.postValue(1)
            }

            override fun onSuccess(users: List<User>) {
                TODO("Not yet implemented")
            }

            override fun onError(it: Throwable) {
                loginStatus.postValue(0)
            }

        },userName,password)
    }
}