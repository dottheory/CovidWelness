package com.app.covidwelness.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0
) {
}