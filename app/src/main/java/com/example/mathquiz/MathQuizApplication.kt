package com.example.mathquiz

import android.app.Application
import com.example.mathquiz.data.QuizRepositoryWithDB

class MathQuizApplication : Application() {
    val repository by lazy { QuizRepositoryWithDB(this) }
}