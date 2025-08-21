package com.example.mathquiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mathquiz.R
import com.example.mathquiz.ui.theme.DarkText
import com.example.mathquiz.ui.theme.PastelBlue

@Composable
fun QuizOptionsScreen(
    operationType: String,
    onNavigateToQuiz: (String, String) -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.home_background),
            contentDescription = "Options Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                text = when (operationType) {
                    "addition" -> "Addition Options"
                    "subtraction" -> "Subtraction Options"
                    "multiplication" -> "Multiplication Options"
                    "division" -> "Division Options"
                    else -> "Options"
                },
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            when (operationType) {
                "addition" -> {
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "add_10") },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Problems Adding Up to 10")
                    }
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "add_100") },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Problems Adding Up to 100")
                    }
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "random") },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Random Addition")
                    }
                }
                "subtraction" -> {
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "sub_10") },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Problems Subtracting Up to 10")
                    }
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "sub_100") },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Problems Subtracting Up to 100")
                    }
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "random") },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Random Subtraction")
                    }
                }
                "multiplication" -> {
                    (1..9).forEach { num ->
                        Button(
                            onClick = { onNavigateToQuiz(operationType, "mult_$num") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .width(250.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PastelBlue,
                                contentColor = DarkText
                            )
                        ) {
                            Text(text = "Problems Multiplying ×$num")
                        }
                    }
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "random") },
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Random Multiplication")
                    }
                }
                "division" -> {
                    (1..9).forEach { num ->
                        Button(
                            onClick = { onNavigateToQuiz(operationType, "div_$num") },
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .width(250.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PastelBlue,
                                contentColor = DarkText
                            )
                        ) {
                            Text(text = "Problems Dividing ÷$num")
                        }
                    }
                    Button(
                        onClick = { onNavigateToQuiz(operationType, "random") },
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PastelBlue,
                            contentColor = DarkText
                        )
                    ) {
                        Text(text = "Random Division")
                    }
                }
            }

            // Back Button
            Button(
                onClick = onNavigateBack,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelBlue,
                    contentColor = DarkText
                )
            ) {
                Text(text = "Back")
            }
        }
    }
}