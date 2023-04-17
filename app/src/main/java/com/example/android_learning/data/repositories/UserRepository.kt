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

    fun addUser(vararg newUsers: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.insertAll(*newUsers)
        }
    }
}