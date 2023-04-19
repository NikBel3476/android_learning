package com.example.android_learning.di

import android.content.Context
import androidx.room.Room
import com.example.android_learning.data.AppDatabase
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.data.repositories.UserRepository
import com.example.android_learning.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideAppDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    fun provideUserDao(appDb: AppDatabase) = appDb.userDao

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)
}