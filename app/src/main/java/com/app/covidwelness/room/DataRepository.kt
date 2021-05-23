package com.app.covidwelness.room

import com.app.covidwelness.util.OnConfigurationListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataRepository @Inject constructor(private val userDao: UserDao) {


    suspend fun insertUser(user: User) {
        return userDao.insertAll(user)

    }

    suspend fun getAllUsers(): List<User> {

        return userDao.getAll()
    }
}