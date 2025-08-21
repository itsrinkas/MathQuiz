package com.example.mathquiz.data

import android.content.Context
import androidx.room.Room
import com.example.mathquiz.data.database.QuizDatabase
import com.example.mathquiz.data.database.QuizResult

class QuizRepositoryWithDB(context: Context) {
    private val database = Room.databaseBuilder(
        context.applicationContext,
        QuizDatabase::class.java, "quiz_database"
    ).build()

    private val quizDao = database.quizDao()

    fun generateQuestions(operationType: String, option: String, count: Int): List<MathQuestion> {
        return List(count) { MathQuestion.generateQuestion(operationType, option) }
    }

    suspend fun saveQuizResult(operationType: String, score: Int, totalQuestions: Int) {
        val result = QuizResult(
            operationType = operationType,
            score = score,
            totalQuestions = totalQuestions
        )
        quizDao.insert(result)
    }
}