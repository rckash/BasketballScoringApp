package com.example.basketballscoringapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var scoreAway: Int = 0
    var scoreHome: Int = 0
    var isAwayScore: Boolean = false
    var isWinnerAway: Boolean = false

    fun add2Points() {
        if (isAwayScore) {
            scoreAway += 2
        } else {
            scoreHome += 2
        }
    }

    fun add3Points() {
        if (isAwayScore) {
            scoreAway += 3
        } else {
            scoreHome += 3
        }
    }

    fun add1Point() {
        if (isAwayScore) {
            scoreAway++
        } else {
            scoreHome++
        }
    }

    fun toggleAwayScore() {
        isAwayScore = true
    }

    fun toggleHomeScore() {
        isAwayScore = false
    }

    fun declareWinner() {
        isWinnerAway = scoreAway > scoreHome
    }

    fun clearScores() {
        scoreHome = 0
        scoreAway = 0
    }

    fun decrementScore() {
        if (isAwayScore) {
            scoreAway -= 1
        } else {
            scoreHome -= 1
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}