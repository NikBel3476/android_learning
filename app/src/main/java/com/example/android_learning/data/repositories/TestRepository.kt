package com.example.android_learning.data.repositories

import com.example.android_learning.data.dao.TestDao
import com.example.android_learning.domain.repo.Test

class TestRepository(private val testDao: TestDao) {
    suspend fun getAll() = testDao.getAll()

    suspend fun getWithQuestions(id: Long) = testDao.getTestWithQuestions(id)

    suspend fun getUserTests(userId: Long) = testDao.getUserTests(userId)

    suspend fun getById(id: Long): Test? = testDao.getById(id)

    suspend fun addTest(newTest: Test): Long = testDao.insert(newTest)
}