package com.example.mathematic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_kiriw.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var q = 0
    val signs = arrayOf("+", "-", "*", "/")
    var a: ArrayList<Button> = arrayListOf()
    val z = mutableListOf(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a = arrayListOf(button1, button2, button3, button4)
        belgi()
        val timer = object : CountDownTimer(60000, 60000) {
            override fun onTick(millisUntilFinished: Long) {
                text4.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                goToResultActivity()
            }
        }
        timer.start()
    }

    fun goToResultActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("durisjuwap", q)
        // intent.putExtra("durisjuwap",intent.getStringExtra("durisjuwap"))
        startActivity(intent)
        finish()
    }
/*
    fun mintent() {
        val intent = Intent(this,Result::class.java)
        intent.putExtra("durisjuwap",q)
        startActivity(intent)
    }*/

    fun belgi() {
        var x = Random.nextInt(-150, 250)
        var y = Random.nextInt(-100, 100)
        z.shuffle()
        text1.text = x.toString()
        text2.text = y.toString()
        a.shuffle()
        var c = Random.nextInt(0, 4)
        text3.text = signs[c]
        when (c) {
            0 -> a[0].text = (x + y).toString()
            1 -> a[0].text = (x - y).toString()
            2 -> a[0].text = (x * y).toString()
            3 -> {
                val correctAnswer = Random.nextInt(-50, 50)
                x = correctAnswer * y
                text1.text = x.toString()
                text2.text = y.toString()
                a[0].text = correctAnswer.toString()
            }
        }
        a[1].text = (a[0].text.toString().toInt() + z[0]).toString()
        a[2].text = (a[0].text.toString().toInt() - z[1]).toString()
        a[3].text = (a[0].text.toString().toInt() + z[2]).toString()
    }

    fun buttonClick(view: View) {
        if ((view as Button) == a[0]) {
            q++
            table.text = q.toString()
            belgi()
        } else {
            belgi()
        }
    }
}