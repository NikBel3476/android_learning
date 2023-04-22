package com.example.android_learning.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

/*enum class Screen(
    val screenName: String,
    val showScreen: @Composable (navigate: (() -> Unit)?) -> Unit,
    val navigate: ((navController: NavController) -> Unit)? = null
) {
    LoginScreen(
        "login",
        showScreen = { navigate -> LoginScreen(navigate = navigate) },
        navigate = { it.navigate("tests") }),
    TestsScreen("tests", { TestsScreen() }),
    TestScreen("tests/{testId}")
}*/

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login")
    object TestsScreen: Screen("user/tests/{userId}")
    object TestDetailsScreen: Screen("tests/{testId}")
    object TestResultsScreen: Screen("testResults")
}
