package com.example.android_learning.ui.screens

import androidx.compose.runtime.Composable

enum class Screen(val screenName: String, val showScreen: @Composable () -> Unit) {
    LoginScreen("login", { LoginScreen() }),
    TestsScreen("tests", { TestsScreen() })
}
