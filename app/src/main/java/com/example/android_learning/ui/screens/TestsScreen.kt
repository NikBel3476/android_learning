package com.example.android_learning.ui.screens

import TestWidget
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
    ) {
        repeat(5) {
            TestWidget("Тест на сообразительность", 3)
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