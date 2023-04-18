package com.example.android_learning.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.domain.repo.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {
    val getAll = MutableLiveData<List<User>>()
    val foundUser = MutableLiveData<User>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun findUserById(id: Long): User? {
        return userDao.findById(id)
    }

    fun findUserByLogin(login: String): User? {
        return userDao.findByLogin(login)
    }

    fun addUser(newUser: User): Long? {
        var id: Long? = null
        coroutineScope.launch(Dispatchers.IO) {
            id = userDao.insertAll(newUser)
        }
        return id
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(userDao: UserDao) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userDao).also { instance = it }
            }
    }
}