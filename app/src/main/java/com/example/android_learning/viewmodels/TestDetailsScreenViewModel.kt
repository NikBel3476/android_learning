package com.example.android_learning.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_learning.data.repositories.QuestionRepository
import com.example.android_learning.data.repositories.TestRepository
import com.example.android_learning.domain.repo.TestQuestion
import com.example.android_learning.domain.repo.TestResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestDetailsScreenViewModel @Inject constructor(
    private val testRepository: TestRepository,
    private val questionRepository: QuestionRepository
) : ViewModel() {
    var questions: List<TestQuestion> by mutableStateOf(emptyList())
    var testResults: TestResults? by mutableStateOf(null)

    fun getQuestions(testId: Long) {
        viewModelScope.launch {
            val testWithQuestions = testRepository.getWithQuestions(testId)
            if (testWithQuestions != null) {
                questions = testWithQuestions.questions.mapNotNull {
                    questionRepository.getWithOptionsAndAnswers(it.questionId)
                }
            }
        }
    }
}