package com.example.mathquiz.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_results")
data class QuizResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val operationType: String,
    val score: Int,
    val totalQuestions: Int,
    val date: Long = System.currentTimeMillis()
)