package com.app.covidwelness.room

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    suspend fun getAll():List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: User)

    @Update
    suspend fun update(users: User)

    @Query("SELECT * FROM User")
    fun observeAllShoppingItems(): LiveData<List<User>>
}