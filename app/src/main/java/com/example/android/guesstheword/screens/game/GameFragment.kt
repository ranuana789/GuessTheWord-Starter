/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.game_fragment.view.*

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {


    private lateinit var binding: GameFragmentBinding

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )

        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.endGameButton.setOnClickListener { onEndGame() }
        binding.skipButton.setOnClickListener { onSkip() }

        updateScoreText()
        updateWordText()

        return binding.root

    }


    /** Methods for button click handlers **/

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }
    private fun onCorrect() {
        viewModel.onCorrect()
        updateScoreText()
        updateWordText()
    }


    /** Methods for updating the UI **/

    private fun updateWordText() {
        setImage(viewModel.word)
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }

    private fun onEndGame() {
        gameFinished()
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun setImage(number: Int){
        when (number) {
            1 -> {
                binding.imageView.setImageResource(R.drawable.im1)
                binding.wordText.text = getText(R.string.s1) }
            2-> {
                binding.imageView.setImageResource(R.drawable.im2)
                binding.wordText.text = getText(R.string.s2) }
            3-> {
                binding.imageView.setImageResource(R.drawable.im3)
                binding.wordText.text = getText(R.string.s3) }
            4 -> {
                binding.imageView.setImageResource(R.drawable.im4)
                binding.wordText.text = getText(R.string.s4) }
            5 -> {
                binding.imageView.setImageResource(R.drawable.im5)
                binding.wordText.text = getText(R.string.s5) }
            6 -> {
                binding.imageView.setImageResource(R.drawable.im6)
                binding.wordText.text = getText(R.string.s6) }
            7 -> {
                binding.imageView.setImageResource(R.drawable.im7)
                binding.wordText.text = getText(R.string.s7) }
            8 -> {
                binding.imageView.setImageResource(R.drawable.im8)
                binding.wordText.text = getText(R.string.s8) }
            9 -> {
                binding.imageView.setImageResource(R.drawable.im9)
                binding.wordText.text = getText(R.string.s9) }
            10 -> {
                binding.imageView.setImageResource(R.drawable.im10)
                binding.wordText.text = getText(R.string.s10) }
            11 -> {
                binding.imageView.setImageResource(R.drawable.im11)
                binding.wordText.text = getText(R.string.s11) }
            else -> {
                binding.imageView.setImageResource(R.drawable.im12)
                binding.wordText.text = getText(R.string.s12)
            }
        }

    }
}
