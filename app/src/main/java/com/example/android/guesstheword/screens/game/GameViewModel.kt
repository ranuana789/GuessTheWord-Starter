package com.example.android.guesstheword.screens.game

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    // The current word
    var word = 0
    // The current score
    var score = 0
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<Int>

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        wordList.shuffle()

    }

    init {
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/
    fun onSkip() {
        if (wordList.isEmpty()){
            return
        }
        score--
        nextWord()
    }

    fun onCorrect() {
        if (wordList.isEmpty()){
            return
        }
        score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}
