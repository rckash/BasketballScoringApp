package com.example.basketballscoringapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscoringapp.databinding.ActivityMainBinding

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
        binding.btnGameEnd.setOnClickListener {
            viewModel.clearScores()
            binding.tvScoreAway.text = viewModel.scoreAway.toString()
            binding.tvScoreHome.text = viewModel.scoreAway.toString()
        }
    }
}