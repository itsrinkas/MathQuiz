package com.example.mathquiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mathquiz.R
import com.example.mathquiz.data.MathQuestion
import com.example.mathquiz.data.QuizRepositoryWithDB
import com.example.mathquiz.ui.theme.DarkText
import com.example.mathquiz.ui.theme.PastelPink
import kotlinx.coroutines.launch

@Composable
fun QuizScreen(
    operationType: String,
    option: String,
    repository: QuizRepositoryWithDB,
    onQuizComplete: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // Background images
    val backgroundImage = when (operationType) {
        "addition" -> R.drawable.quiz_screen_background
        "subtraction" -> R.drawable.quiz_screen_background
        "multiplication" -> R.drawable.quiz_screen_background
        "division" -> R.drawable.quiz_screen_background
        else -> null
    }

    val questions = remember { repository.generateQuestions(operationType, option, 5) }
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }
    var feedback by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        backgroundImage?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (currentQuestionIndex < questions.size) {
                val currentQuestion = questions[currentQuestionIndex]
                QuizQuestion(
                    question = currentQuestion,
                    selectedAnswer = selectedAnswer,
                    feedback = feedback,
                    currentQuestionIndex = currentQuestionIndex,
                    totalQuestions = questions.size,
                    onAnswerSelected = { answer ->
                        selectedAnswer = answer
                        feedback = if (answer == currentQuestion.correctAnswer) {
                            score++
                            "Correct!"
                        } else {
                            "Wrong! Correct answer: ${currentQuestion.correctAnswer}"
                        }
                    },
                    onNextQuestion = {
                        selectedAnswer = null
                        feedback = ""
                        currentQuestionIndex++
                        if (currentQuestionIndex == questions.size) {
                            coroutineScope.launch {
                                repository.saveQuizResult(operationType, score, questions.size)
                                onQuizComplete(score, questions.size)
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun QuizQuestion(
    question: MathQuestion,
    selectedAnswer: Int?,
    feedback: String,
    currentQuestionIndex: Int,
    totalQuestions: Int,
    onAnswerSelected: (Int) -> Unit,
    onNextQuestion: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = when (question.operationType) {
                "addition" -> "${question.firstNumber} + ${question.secondNumber} = ?"
                "subtraction" -> "${question.firstNumber} - ${question.secondNumber} = ?"
                "multiplication" -> "${question.firstNumber} × ${question.secondNumber} = ?"
                "division" -> "${question.firstNumber} ÷ ${question.secondNumber} = ?"
                else -> ""
            },
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        question.options.forEach { option ->
            Button(
                onClick = { if (selectedAnswer == null) onAnswerSelected(option) },
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedAnswer == null,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPink,
                    contentColor = DarkText
                )
            ) {
                Text(text = option.toString())
            }
        }
        if (selectedAnswer != null) {
            Text(
                text = feedback,
                color = if (feedback.startsWith("Correct")) Color.Green else Color.Red,
                style = MaterialTheme.typography.bodyLarge
            )
            Button(
                onClick = onNextQuestion,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPink,
                    contentColor = DarkText
                )
            ) {
                Text(text = if (currentQuestionIndex < totalQuestions - 1) "Next" else "Finish")
            }
        }
    }
}