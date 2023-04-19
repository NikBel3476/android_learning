package com.example.android_learning.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.domain.repo.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {
    fun getAll() = userDao.getAll()

    suspend fun findUserById(id: Long): User? = userDao.findById(id)

    suspend fun findUserByLogin(login: String): User? = userDao.findByLogin(login)

    suspend fun addUser(newUser: User): Long = userDao.insertAll(newUser)
}