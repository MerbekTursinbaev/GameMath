package com.example.mathematic

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import java.util.prefs.AbstractPreferences

class Result : AppCompatActivity() {

    private var currentResult = 0
    private var maxScore = 0
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        preferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        maxScore = preferences.getInt("max_score",0)
        currentResult = intent.getIntExtra("durisjuwap",0)
        tvResult.text = "$currentResult"
        if (currentResult > maxScore) {
            preferences.edit().putInt("max_crore",currentResult).apply()
        }
        tvMaxScore.text = "Max Score is ${preferences.getInt("max_score",0)}"
    }
}