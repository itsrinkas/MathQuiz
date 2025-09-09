# MathQuiz
An interactive Android quiz app built with Kotlin, allowing users to practice addition, subtraction, multiplication, and division with number ranges up to 10, 100, or randomly selected. Designed for fun and flexible math learning.

## Features
- Choose from **Addition**, **Subtraction**, **Multiplication**, and **Division**
- Practice problems that add up to **10**, **100**, or are **randomized**
- Simple, clean interface optimized for learning
- Score tracking for each quiz session


##  How It Works

1. **Main Menu**: Select an operation and difficulty level.
2. **Quiz Flow**:
   - The app generates random problems based on your selection.
   - After each answer, it shows feedback (correct/incorrect) and updates your score.
3. **Navigation**: Users can return to the main screen or restart any quiz mode.
4. **Code Structure**:
   - `MainActivity.kt`: Handles the initial menu and navigation logic.
   - Individual activity files (e.g., `AdditionActivity.kt`): Manage quiz logic and UI for each operation.
   - Layout files: Defined under `res/layout/`, control screen design (buttons, text views, score display).
   - **Scoring system**: Keeps track of correct answers and displays cumulative results.
   - **Randomization logic**: Uses Kotlin's `Random()` to generate arithmetic questions within selected ranges.

## Demo

[Watch the demo](https://youtu.be/8M98Fg1thB4)


## Tech Stack
- **Language:** Kotlin
- **Platform:** Android
- **Build Tool:** Gradle




---

Built as a final project for Mobile App Development at the University of Limerick.
>>>>>>> f042dd9278466d76a7bf1236e884d2e97f0161e4
