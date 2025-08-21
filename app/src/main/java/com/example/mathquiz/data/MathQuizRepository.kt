package com.example.mathquiz.data

import kotlin.random.Random

class MathQuizRepository {
    fun generateQuestions(operationType: String, count: Int = 5): List<MathQuestion> {
        return List(count) { generateQuestion(operationType) }
    }

    private fun generateQuestion(operationType: String): MathQuestion {
        return when (operationType) {
            "addition" -> generateAdditionQuestion()
            "subtraction" -> generateSubtractionQuestion()
            else -> generateAdditionQuestion()
        }
    }

    private fun generateAdditionQuestion(): MathQuestion {
        val firstNumber = Random.nextInt(1, 20)
        val secondNumber = Random.nextInt(1, 20)
        val correctAnswer = firstNumber + secondNumber
        return MathQuestion(
            firstNumber = firstNumber,
            secondNumber = secondNumber,
            operationType = "addition",
            options = generateOptions(correctAnswer),
            correctAnswer = correctAnswer
        )
    }

    private fun generateSubtractionQuestion(): MathQuestion {
        val firstNumber = Random.nextInt(10, 30)
        val secondNumber = Random.nextInt(1, firstNumber)
        val correctAnswer = firstNumber - secondNumber
        return MathQuestion(
            firstNumber = firstNumber,
            secondNumber = secondNumber,
            operationType = "subtraction",
            options = generateOptions(correctAnswer),
            correctAnswer = correctAnswer
        )
    }

    private fun generateOptions(correctAnswer: Int): List<Int> {
        val options = mutableSetOf(correctAnswer)
        while (options.size < 4) {
            val offset = Random.nextInt(-5, 6)
            val option = (correctAnswer + offset).coerceIn(1, 50)
            if (option != correctAnswer) options.add(option)
        }
        return options.shuffled()
    }
}