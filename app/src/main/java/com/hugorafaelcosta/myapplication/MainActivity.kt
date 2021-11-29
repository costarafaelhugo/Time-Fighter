package com.hugorafaelcosta.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton: Button
    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeTextView: TextView

    internal var score = 0

    internal var gameStarted = false

    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown: Long = 60000
    internal val countDownInterval: Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.TapMeButton)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
        timeTextView = findViewById(R.id.timeTextView)

        tapMeButton.setOnClickListener {
            incrementScore()
        }

     resetGame()
    }

    private fun resetGame(){
        score = 0

        gameScoreTextView.text = getString(R.string.playerScore, score)

        val initialTimeLeft = initialCountDown / 1000
        timeTextView.text = getString(R.string.playerTime, initialTimeLeft)

        countDownTimer = object : CountDownTimer (initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timeTextView.text = getString(R.string.playerTime, timeLeft)
            }

            override fun onFinish() {
             endGame()
            }
        }
        gameStarted = false
    }

    @SuppressLint("StringFormatInvalid")
    private fun incrementScore() {
        if(!gameStarted){
            startGame()
        }
        score += 1
        val newScore = getString(R.string.playerScore, score)
        gameScoreTextView.text = newScore
    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.gameOverMessage,score), Toast.LENGTH_LONG).show()
        resetGame()
    }
}