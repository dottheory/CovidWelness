package com.app.covidwelness.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.covidwelness.room.DataRepository
import com.app.covidwelness.room.User
import com.app.covidwelness.util.OnConfigurationListener
import kotlinx.coroutines.launch
import kotlin.math.log


class LoginViewModel @ViewModelInject constructor(private val repository: DataRepository)  : ViewModel(){

    val insertStatus = MutableLiveData<Int>()
    val loginStatus = MutableLiveData<Int>()


    fun insertUser(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
            //Need to find better way to handle insert status
            insertStatus.postValue(1)
        }
    }
    fun validateUser(userName: String,password :String) {
        viewModelScope.launch {
           val  users:List<User> = repository.getAllUsers()
            if(users.isNotEmpty()){
                var status = false;
                for(user in users){
                    if(user.userName == userName && user.password == password){
                        status = true
                        break
                    }
                }
                if(status){
                    loginStatus.postValue(1)
                }else{
                    loginStatus.postValue(0)
                }
            }else{
                loginStatus.postValue(0)
            }
        }
    }
}