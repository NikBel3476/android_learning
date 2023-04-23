package com.example.android_learning.data.repositories

import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.domain.repo.User
import com.example.android_learning.domain.repo.UserWithTests

class UserRepository(private val userDao: UserDao) {
    suspend fun getAll() = userDao.getAll()

    suspend fun getUserById(id: Long): User? = userDao.findById(id)

    suspend fun getUserByLogin(login: String): User? = userDao.findByLogin(login)

    suspend fun getUserWithTests(id: Long): UserWithTests = userDao.getUserWithTests(id)

    suspend fun addUser(newUser: User): Long = userDao.insert(newUser)
}