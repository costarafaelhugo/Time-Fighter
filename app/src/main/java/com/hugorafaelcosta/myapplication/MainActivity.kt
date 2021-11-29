package com.hugorafaelcosta.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal var score = 0

    internal lateinit var tapMeButton: Button
    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tapMeButton = findViewById(R.id.TapMeButton)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
        timeTextView = findViewById(R.id.timeTextView)

        tapMeButton.setOnClickListener {
            incrementScore()
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun incrementScore() {
        score += 1
        val newScore = getString(R.string.player_score, score)
        gameScoreTextView.text = newScore
    }
}