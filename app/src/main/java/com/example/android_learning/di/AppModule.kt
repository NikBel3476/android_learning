package com.example.android_learning.di

import android.content.Context
import com.example.android_learning.data.AppDatabase
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.data.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = AppDatabase.getInstance(context)

    @Provides
    fun provideUserDao(appDb: AppDatabase) = appDb.userDao()

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)
}