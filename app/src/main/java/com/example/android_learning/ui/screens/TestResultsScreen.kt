package com.example.android_learning.ui.screens

import BackPressHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.android_learning.R
import com.example.android_learning.viewmodels.TestDetailsScreenViewModel

@Composable
fun TestResultsScreen(
    testDetailsScreenViewModel: TestDetailsScreenViewModel,
    navigateToUserTests: () -> Unit
) {
    val testResults = testDetailsScreenViewModel.testResults

    BackPressHandler(onBackPressed = navigateToUserTests)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (testResults == null) {
                true -> Text(
                    text = "Что-то пошло не так",
                    fontSize = 32.sp
                )
                false -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Правильно: ${testResults.score} из ${testResults.maxScore}",
                            fontSize = 32.sp
                        )
                        Text(
                            "Тест ${if (testResults.score >= testResults.scoreToPass) "пройден" else "не пройден"}",
                            fontSize = 24.sp
                        )
                    }
                }
            }
            Button(onClick = navigateToUserTests) {
                Text(stringResource(R.string.test_results_button_text))
            }
        }
    }
}