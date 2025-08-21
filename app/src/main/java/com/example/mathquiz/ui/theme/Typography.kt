package com.example.mathquiz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mathquiz.R


val BubblegumSans = FontFamily(
    Font(R.font.bubblegum_sans_regular, FontWeight.Normal)
)
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = BubblegumSans,
        fontWeight = FontWeight.Bold, // Header
        fontSize = 36.sp, // Main headers
        lineHeight = 40.sp,
        letterSpacing = 0.5.sp,
        color = Color(0xFFDD2C00) // Colour headers
    ),
    headlineMedium = TextStyle(
        fontFamily = BubblegumSans,
        fontWeight = FontWeight.Bold, // Subheaders
        fontSize = 24.sp, // Subheaders size
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp,
        color = Color(0xFFDD2C00) // Subheaders colour
    ),
    headlineSmall = TextStyle(
        fontFamily = BubblegumSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp, //Quiz results text
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color(0xFF1C2526)
    ),
    bodyLarge = TextStyle(
        fontFamily = BubblegumSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color(0xFF1C2526) // Dark colour
    )
)