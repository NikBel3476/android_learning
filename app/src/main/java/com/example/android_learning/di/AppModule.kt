package com.example.android_learning.di

import android.content.Context
import com.example.android_learning.data.AppDatabase
import com.example.android_learning.data.dao.QuestionDao
import com.example.android_learning.data.dao.TestDao
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.data.repositories.QuestionRepository
import com.example.android_learning.data.repositories.TestRepository
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
    fun provideAppDb(
        @ApplicationContext
        context: Context
    ) = AppDatabase.getInstance(context)

    @Provides
    fun provideUserDao(appDb: AppDatabase) = appDb.userDao

    @Provides
    fun provideUserRepository(userDao: UserDao) = UserRepository(userDao)

    @Provides
    fun provideTestDao(appDb: AppDatabase) = appDb.testDao

    @Provides
    fun provideTestRepository(testDao: TestDao) = TestRepository(testDao)

    @Provides
    fun provideQuestionDao(appDb: AppDatabase) = appDb.questionDao

    @Provides
    fun provideQuestionRepository(questionDao: QuestionDao) = QuestionRepository(questionDao)
}