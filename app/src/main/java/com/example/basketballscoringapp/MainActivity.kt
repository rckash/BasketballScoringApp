package com.example.basketballscoringapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscoringapp.databinding.ActivityMainBinding
import java.util.Random
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.tvScoreAway.text = viewModel.scoreAway.toString()
        binding.tvScoreHome.text = viewModel.scoreHome.toString()

        binding.btn2PointsAway.setOnClickListener {
            viewModel.toggleAwayScore()
            viewModel.add2Points()
            binding.tvScoreAway.text = viewModel.scoreAway.toString()
        }
        binding.btn2pointsHome.setOnClickListener {
            viewModel.toggleHomeScore()
            viewModel.add2Points()
            binding.tvScoreHome.text = viewModel.scoreHome.toString()
        }
        binding.btn3pointsAway.setOnClickListener {
            viewModel.toggleAwayScore()
            viewModel.add3Points()
            binding.tvScoreAway.text = viewModel.scoreAway.toString()
        }
        binding.btn3pointsHome.setOnClickListener {
            viewModel.toggleHomeScore()
            viewModel.add3Points()
            binding.tvScoreHome.text = viewModel.scoreHome.toString()
        }
        binding.btnFreethrowAway.setOnClickListener {
            viewModel.toggleAwayScore()
            viewModel.add1Point()
            binding.tvScoreAway.text = viewModel.scoreAway.toString()
        }
        binding.btnFreethrowHome.setOnClickListener {
            viewModel.toggleHomeScore()
            viewModel.add1Point()
            binding.tvScoreHome.text = viewModel.scoreHome.toString()
        }
        binding.btnMinusOneAway.setOnClickListener {
            viewModel.toggleAwayScore()
            viewModel.decrementScore()
            binding.tvScoreAway.text = viewModel.scoreAway.toString()
        }
        binding.btnMinusOneHome.setOnClickListener {
            viewModel.toggleHomeScore()
            viewModel.decrementScore()
            binding.tvScoreHome.text = viewModel.scoreHome.toString()
        }
        binding.btnGameEnd.setOnClickListener {
            viewModel.declareWinner()
            viewModel.clearScores()
            binding.tvScoreAway.text = viewModel.scoreAway.toString()
            binding.tvScoreHome.text = viewModel.scoreHome.toString()
            if (viewModel.isWinnerAway) {
                changeTextColorEverySecond(binding.tvScoreAway)
            } else {
                changeTextColorEverySecond(binding.tvScoreHome)
            }
        }
    }

    fun changeTextColorEverySecond(textView: TextView) {
        val colors = arrayOf(
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.BLACK
        )

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val textColor = colors[Random().nextInt(colors.size)]
                textView.setTextColor(textColor)
            }
        }, 0, 500)
    }
}