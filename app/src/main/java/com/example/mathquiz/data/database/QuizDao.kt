package com.example.mathquiz.data.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface QuizDao {
    @Insert
    suspend fun insert(quizResult: QuizResult)
}