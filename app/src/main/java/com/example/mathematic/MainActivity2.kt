package com.example.mathematic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private var natiyje: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        natiyje = intent.getIntExtra("durisjuwap",0)
        juwap.text = "${natiyje}"

        buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        buttonResult.setOnClickListener {
            startActivity(Intent(this, Result::class.java))
        }
    }
}