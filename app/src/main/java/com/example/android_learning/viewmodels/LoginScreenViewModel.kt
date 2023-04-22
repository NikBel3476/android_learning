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

    fun login(
        login: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        viewModelScope.launch {
            val existingUser = repository.getUserByLogin(login)
            when (existingUser != null) {
                true -> when (password == existingUser.password) {
                    true -> {
                        user = existingUser
                        onSuccess()
                    }
                    false -> onFailure("Wrong password")
                }
                false -> {
                    val id = repository.addUser(User(0, login, password))
                    user = repository.getUserById(id)
                    onSuccess()
                }
            }
        }
    }
}