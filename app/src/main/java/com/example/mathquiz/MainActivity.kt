package com.example.mathquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathquiz.ui.screens.HomeScreen
import com.example.mathquiz.ui.screens.QuizOptionsScreen
import com.example.mathquiz.ui.screens.QuizResultsScreen
import com.example.mathquiz.ui.screens.QuizScreen
import com.example.mathquiz.ui.theme.MathQuizTheme
import com.example.mathquiz.data.QuizRepositoryWithDB

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = (application as MathQuizApplication).repository
        setContent {
            MathQuizApp(repository = repository)
        }
    }
}

@Composable
fun MathQuizApp(repository: QuizRepositoryWithDB) {
    val navController = rememberNavController()

    MathQuizTheme {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    onNavigateToOptions = { operationType ->
                        navController.navigate("options/$operationType")
                    }
                )
            }
            composable("options/{operationType}") { backStackEntry ->
                val operationType = backStackEntry.arguments?.getString("operationType") ?: "addition"
                QuizOptionsScreen(
                    operationType = operationType,
                    onNavigateToQuiz = { opType, option ->
                        navController.navigate("quiz/$opType/$option")
                    },
                    onNavigateBack = {
                        navController.popBackStack("home", inclusive = false)
                    }
                )
            }
            composable("quiz/{operationType}/{option}") { backStackEntry ->
                val operationType = backStackEntry.arguments?.getString("operationType") ?: "addition"
                val option = backStackEntry.arguments?.getString("option") ?: "random"
                QuizScreen(
                    operationType = operationType,
                    option = option,
                    repository = repository,
                    onQuizComplete = { score, totalQuestions ->
                        navController.navigate("results/$score/$totalQuestions")
                    }
                )
            }
            composable("results/{score}/{totalQuestions}") { backStackEntry ->
                val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
                val totalQuestions = backStackEntry.arguments?.getString("totalQuestions")?.toIntOrNull() ?: 0
                QuizResultsScreen(
                    score = score,
                    totalQuestions = totalQuestions,
                    onBackToHome = {
                        navController.popBackStack("home", inclusive = false)
                    }
                )
            }
        }
    }
}