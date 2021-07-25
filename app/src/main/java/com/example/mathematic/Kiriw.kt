package com.example.mathematic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_kiriw.*

class Kiriw : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiriw)
        userName.error = "Atindi kirit"
        buttonStart.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}