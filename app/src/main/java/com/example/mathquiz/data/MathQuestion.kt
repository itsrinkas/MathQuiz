package com.example.mathquiz.data

import kotlin.random.Random

data class MathQuestion(
    val operationType: String,
    val firstNumber: Int,
    val secondNumber: Int,
    val correctAnswer: Int,
    val options: List<Int>
) {
    companion object {
        fun generateQuestion(operationType: String, option: String): MathQuestion {
            val (firstNumber: Int, secondNumber: Int, correctAnswer: Int) = when (operationType) {
                "addition" -> {
                    when (option) {
                        "add_10" -> {
                            val second = Random.nextInt(1, 10) // Second number up to 9
                            val first = Random.nextInt(0, 10 - second + 1) // First number ensures sum <= 10
                            Triple(first, second, first + second)
                        }
                        "add_100" -> {
                            val second = Random.nextInt(1, 100) // Second number up to 99
                            val first = Random.nextInt(0, 100 - second + 1) // First number ensures sum <= 100
                            Triple(first, second, first + second)
                        }
                        "random" -> {
                            val second = Random.nextInt(1, 1000)
                            val first = Random.nextInt(1, 1000)
                            Triple(first, second, first + second)
                        }
                        else -> {
                            val second = Random.nextInt(1, 100)
                            val first = Random.nextInt(1, 100)
                            Triple(first, second, first + second)
                        }
                    }
                }
                "subtraction" -> {
                    when (option) {
                        "sub_10" -> {
                            val first = Random.nextInt(1, 11) // First number up to 10
                            val second = Random.nextInt(1, first + 1) // Second number ensures difference >= 0
                            Triple(first, second, first - second)
                        }
                        "sub_100" -> {
                            val first = Random.nextInt(1, 101) // First number up to 100
                            val second = Random.nextInt(1, first + 1) // Second number ensures difference >= 0
                            Triple(first, second, first - second)
                        }
                        "random" -> {
                            val second = Random.nextInt(1, 1000)
                            val first = Random.nextInt(second + 1, 1000)
                            Triple(first, second, first - second)
                        }
                        else -> {
                            val second = Random.nextInt(1, 100)
                            val first = Random.nextInt(second + 1, 100)
                            Triple(first, second, first - second)
                        }
                    }
                }
                "multiplication" -> {
                    val second = when (option) {
                        "mult_1" -> 1
                        "mult_2" -> 2
                        "mult_3" -> 3
                        "mult_4" -> 4
                        "mult_5" -> 5
                        "mult_6" -> 6
                        "mult_7" -> 7
                        "mult_8" -> 8
                        "mult_9" -> 9
                        "random" -> Random.nextInt(1, 10)
                        else -> Random.nextInt(1, 10)
                    }
                    val first = Random.nextInt(1, 10)
                    Triple(first, second, first * second)
                }
                "division" -> {
                    val second = when (option) {
                        "div_1" -> 1
                        "div_2" -> 2
                        "div_3" -> 3
                        "div_4" -> 4
                        "div_5" -> 5
                        "div_6" -> 6
                        "div_7" -> 7
                        "div_8" -> 8
                        "div_9" -> 9
                        "random" -> Random.nextInt(1, 10)
                        else -> Random.nextInt(1, 10)
                    }
                    val product = Random.nextInt(1, 10) * second
                    Triple(product, second, product / second)
                }
                else -> Triple(0, 0, 0)
            }

            val options = mutableListOf(correctAnswer)
            while (options.size < 4) {
                val wrongAnswer = correctAnswer + Random.nextInt(-10, 10)
                if (wrongAnswer != correctAnswer && wrongAnswer >= 0 && !options.contains(wrongAnswer)) {
                    options.add(wrongAnswer)
                }
            }
            return MathQuestion(operationType, firstNumber, secondNumber, correctAnswer, options.shuffled())
        }
    }
}