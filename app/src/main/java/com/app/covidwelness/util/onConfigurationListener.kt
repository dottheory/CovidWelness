package com.app.covidwelness.util

import com.app.covidwelness.room.User

interface OnConfigurationListener {
    fun onSuccess()
    fun onError(it : Throwable);
    fun onSuccess(users:List<User>)

}