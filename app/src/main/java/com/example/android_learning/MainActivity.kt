package com.example.android_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.android_learning.ui.screens.LoginScreen
import com.example.android_learning.ui.screens.Screen
import com.example.android_learning.ui.screens.TestDetailsScreen
import com.example.android_learning.ui.screens.TestResultsScreen
import com.example.android_learning.ui.screens.TestsScreen
import com.example.android_learning.ui.theme.Android_learningTheme
import com.example.android_learning.viewmodels.LoginScreenViewModel
import com.example.android_learning.viewmodels.TestDetailsScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Android_learningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val loginScreenViewModel: LoginScreenViewModel = hiltViewModel()

    NavHost(navController, startDestination = Screen.LoginScreen.route) {
        composable(
            Screen.LoginScreen.route
        ) {
            LoginScreen(
                loginScreenViewModel,
                navigateToTestsScreen = { userId -> navController.navigate("user/tests/${userId}") }
            )
        }
        composable(
            Screen.TestsScreen.route,
            listOf(navArgument("userId") {
                type = NavType.LongType
            })
        ) {
            val userId = it.arguments?.getLong("userId") ?: 0
            TestsScreen(
                userId = userId,
                navigateToTest = { testId -> navController.navigate("tests/${testId}")},
                navigateToLoginScreen = { navController.navigate(Screen.LoginScreen.route)}
            )
        }
        composable(
            Screen.TestDetailsScreen.route,
            listOf(navArgument("testId") {
                type = NavType.LongType
            })
        ) {
            val testId = it.arguments?.getLong("testId") ?: 0
            TestDetailsScreen(
                loginScreenViewModel = loginScreenViewModel,
                testId = testId,
                navigateToTestResults = { navController.navigate(Screen.TestResultsScreen.route)}
            )
        }
        composable(
            Screen.TestResultsScreen.route
        ) {
            val parentEntry = remember(it) {
                navController.getBackStackEntry(Screen.TestDetailsScreen.route)
            }
            val parentViewModel: TestDetailsScreenViewModel = hiltViewModel(parentEntry)
            val userId = loginScreenViewModel.user?.userId ?: 1
            TestResultsScreen(
                parentViewModel,
                navigateToUserTests = { navController.navigate("user/tests/${userId}")}
            )
        }
//        Screen.values().map { screen ->
//            composable(screen.screenName) {
//                screen.showScreen { screen.navigate?.invoke(navController) }
//            }
//        }
    }
}