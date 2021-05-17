package com.app.covidwelness.room

import android.util.Log
import com.app.covidwelness.util.OnConfigurationListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataRepository @Inject constructor(private val userDao: UserDao) {

    private val compositeDisposable = CompositeDisposable()

    fun insertUser(user: User,callback: OnConfigurationListener){
        userDao?.insertAll(user)?.subscribeOn(Schedulers.io())?.observeOn(
            AndroidSchedulers.mainThread())?.subscribe({
            callback.onSuccess()
        },{
            callback.onError(it)
        })?.let {
            compositeDisposable.addAll(it)
        }
    }

    fun getAllUsers(callback: OnConfigurationListener,username:String,password:String){
        userDao?.getAll()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                it?.forEach {user->
                    var status:Boolean = false;
                    if(user.userName == username){
                        if(user.password == password){
                            callback.onSuccess()
                            status = true
                        }
                    }
                    if(!status){
                        callback.onError(Throwable("Login Failed"))
                    }
                    Log.v("Person Name",user.userName)
                }
            },{
                callback.onError(it)
            })?.let {
            }
    }
}