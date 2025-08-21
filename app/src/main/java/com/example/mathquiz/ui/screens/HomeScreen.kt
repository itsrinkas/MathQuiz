package com.example.mathquiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.mathquiz.ui.theme.PastelPurple

@Composable
fun HomeScreen(
    onNavigateToOptions: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.home_background),
            contentDescription = "Home Background",
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
            // Icon
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Math Quiz Icon",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            // Header
            Text(
                text = "Math Quiz",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Addition
            Button(
                onClick = { onNavigateToOptions("addition") },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .width(250.dp) // Larger width
                    .height(60.dp), // Larger height
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPurple,
                    contentColor = DarkText
                )
            ) {
                Text(text = "Addition Quiz")
            }

            // Subtraction
            Button(
                onClick = { onNavigateToOptions("subtraction") },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .width(250.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPurple,
                    contentColor = DarkText
                )
            ) {
                Text(text = "Subtraction Quiz")
            }

            // Multiplication
            Button(
                onClick = { onNavigateToOptions("multiplication") },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .width(250.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPurple,
                    contentColor = DarkText
                )
            ) {
                Text(text = "Multiplication Quiz")
            }

            // Division
            Button(
                onClick = { onNavigateToOptions("division") },
                modifier = Modifier
                    .width(250.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelPurple,
                    contentColor = DarkText
                )
            ) {
                Text(text = "Division Quiz")
            }
        }
    }
}