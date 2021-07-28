package com.example.mathematic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kiriw.*

class Kiriw : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiriw)
        buttonStart.setOnClickListener {
            if (userName.text.isEmpty()) {
                Toast.makeText(this, "Atindi toliq kirit", Toast.LENGTH_SHORT).show()
            } else {
                val xat = Intent(this, MainActivity::class.java)
                xat.putExtra("ati", userName.text.toString())
                startActivity(xat)
            }
        }
    }
}