package com.example.android_learning.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_learning.R
import com.example.android_learning.domain.repo.TestResults
import com.example.android_learning.viewmodels.TestDetailsScreenViewModel

@Composable
fun TestDetailsScreen(
    viewModel: TestDetailsScreenViewModel = hiltViewModel(),
    testId: Long,
    navigateToTestResults: () -> Unit
) {
    val userAnswers: MutableMap<Long, List<Int>> = remember { mutableStateMapOf() }

    LaunchedEffect(Unit) {
        viewModel.getQuestions(testId)
    }

    fun calculateResults(): TestResults {
        var score = 0
        viewModel.questions.forEach {testQuestion ->
            val answers = testQuestion.answers.map { it.index }
            val userAnswers = userAnswers[testQuestion.question.questionId]
            if (userAnswers == answers) {
                score++
            }
        }
        return TestResults(score = score, maxScore = 5, scoreToPass = 2)
    }

    fun onAnswerButtonClick(questionId: Long, answers: List<Int>) {
        userAnswers[questionId] = answers
    }

    fun onFinishTestButtonClick() {
        viewModel.testResults = calculateResults()
        navigateToTestResults()
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        viewModel.questions.mapIndexed { questionIndex, testQuestion ->
            Text(
                text = "${questionIndex + 1}. ${testQuestion.question.text}",
                fontSize = 24.sp
            )
            Column(
                modifier = Modifier.padding(start = 8.dp).selectableGroup()
            ) {
                testQuestion.options.mapIndexed { optionIndex, questionOption ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            onClick = {
                                onAnswerButtonClick(testQuestion.question.questionId, listOf(optionIndex))
                            },
                            selected = (optionIndex == userAnswers[testQuestion.question.questionId]?.get(0))
                        )
                        Text("${optionIndex + 1}. ${questionOption.text}", fontSize = 20.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        Button(onClick = { onFinishTestButtonClick() }) {
            Text(stringResource(R.string.finish_test_button_text))
        }
    }
}