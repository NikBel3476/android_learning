package com.example.android_learning.ui.screens

import TestWidget
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_learning.ui.theme.Android_learningTheme

@Composable
fun TestsScreen() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        repeat(10) {
            TestWidget("Тест на сообразительность", (1..5).random())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTestsScreen() {
    Android_learningTheme {
        TestsScreen()
    }
}