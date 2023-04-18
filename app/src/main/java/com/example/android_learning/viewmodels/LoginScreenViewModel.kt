package com.example.android_learning.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_learning.data.repositories.UserRepository
import com.example.android_learning.domain.repo.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private var user: User? by mutableStateOf(null)

    fun login(login: String, password: String): Result<User?> {
        val existingUser = repository.findUserByLogin(login)
        if (existingUser != null) {
            return when (password == existingUser.password) {
                true -> Result.success(existingUser)
                false -> Result.failure(Exception("Wrong password"))
            }
        }

        return when (val id = repository.addUser(User(0, login, password))) {
            null -> Result.failure(Exception("Failed to save user in database"))
            else -> {
                val user = repository.findUserById(id)
                return Result.success(user)
            }
        }
    }

    fun findUserByLogin(login: String) = viewModelScope.launch {
        user = repository.findUserByLogin(login)
    }

    fun addUser(user: User) = viewModelScope.launch {
        repository.addUser(user)
    }
}