package com.example.android_learning.ui.screens

import TestWidget
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_learning.ui.theme.Android_learningTheme
import com.example.android_learning.viewmodels.TestsScreenViewModel

@Composable
fun TestsScreen(
    testsViewModel: TestsScreenViewModel = hiltViewModel(),
    userId: Long,
    navigateToTest: (testId: Long) -> Unit
) {
    LaunchedEffect(Unit) {
        testsViewModel.getUserTests(userId)
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        testsViewModel.tests.map {
            TestWidget(
                title = it.name,
                rating = (1..5).random(),
                onButtonClick = { navigateToTest(it.testId) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTestsScreen() {
    Android_learningTheme {
        TestsScreen(
            userId = 1,
            navigateToTest = {}
        )
    }
}