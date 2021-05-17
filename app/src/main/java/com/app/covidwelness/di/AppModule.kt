package com.app.covidwelness.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import com.app.covidwelness.room.AppDatabase
import com.app.covidwelness.room.DataRepository
import com.app.covidwelness.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    private lateinit var database: AppDatabase

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        database = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database.db"
        ).build()
        return database
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideDataRepository(userDao: UserDao): DataRepository {
        return DataRepository(userDao)
    }
}


