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
    suspend fun getAll():List<User>

    @Insert
    suspend fun insertAll(vararg users: User)

    @Update
    suspend fun update(vararg users: User)
}