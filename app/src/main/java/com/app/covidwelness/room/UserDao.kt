package com.app.covidwelness.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll(): Single<List<User>>

    @Insert
    fun insertAll(vararg users: User): Completable

    @Update
    fun update(vararg users: User)
}