package com.example.android_learning.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_learning.data.repositories.QuestionRepository
import com.example.android_learning.data.repositories.TestRepository
import com.example.android_learning.data.repositories.UserRepository
import com.example.android_learning.domain.repo.Test
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestsScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val testRepository: TestRepository,
    private val questionRepository: QuestionRepository
) : ViewModel() {
    var tests: List<Test> by mutableStateOf(emptyList())

    fun getUserTests(userId: Long) {
        viewModelScope.launch {
            tests = testRepository.getUserTests(userId)
        }
    }
}