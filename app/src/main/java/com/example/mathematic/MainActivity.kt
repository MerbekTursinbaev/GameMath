package com.example.mathematic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var q = 0  //juwaplardi sanaw kerek edi biraq sanamay atir :(
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timer.start()
    }

    val timer = object : CountDownTimer(60000,5000) {
        override fun onTick(millisUntilFinished: Long) {
            belgi()
        }

        override fun onFinish() {
            finish()
        }
    }

    override fun finish() {
        val intent = Intent(this,MainActivity2::class.java)
        intent.putExtra("durisjuwap",q)
        startActivity(intent)

    }

    fun belgi() {
        var x = Random.nextInt(-100, 100)
        var y = Random.nextInt(-100, 100)
        var z = mutableListOf(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        z.shuffle()
        text1.text = x.toString()
        text2.text = y.toString()
        var a = arrayListOf(Button1, Button2, Button3, Button4)
        a.shuffle()
        var c = Random.nextInt(0, 4)
        when (c) {
            0 -> {
                text3.text = "+"
                a[0].text = (x + y).toString()
                a[1].text = (a[0].text.toString().toInt() + z[0]).toString()
                a[2].text = (a[0].text.toString().toInt() - z[2]).toString()
                a[3].text = (a[0].text.toString().toInt() + z[3]).toString()
            }
            1 -> {
                text3.text = "-"
                a[0].text = (x - y).toString()
                a[1].text = (a[0].text.toString().toInt() + z[2]).toString()
                a[2].text = (a[0].text.toString().toInt() - z[4]).toString()
                a[3].text = (a[0].text.toString().toInt() + z[5]).toString()
            }
            2 -> {
                text3.text = "*"
                a[0].text = (x * y).toString()
                a[1].text = (a[0].text.toString().toInt() + z[2]).toString()
                a[2].text = (a[0].text.toString().toInt() - z[3]).toString()
                a[3].text =
                        (a[0].text.toString().toInt() + z[5]).toString()
            }
            3 -> {
                text3.text = "/"
                a[0].text = (x.toDouble() / y.toDouble()).toString()
                a[1].text = (a[0].text.toString().toDouble() + z[4].toDouble()).toString()
                a[2].text = (a[0].text.toString().toDouble() - z[5]).toString()
                a[3].text = (a[0].text.toString().toDouble() + z[2]).toString()
            }
        }
        Button1.setOnClickListener {
            if (Button1.text == a[0]) {
                q++
                table.text = q.toString()
            } else {
                belgi()
            }
        }
        Button2.setOnClickListener {
            if (Button2.text == a[0]) {
                q++
                table.text = q.toString()
            } else {
                belgi()
            }
        }
        Button3.setOnClickListener {
            if (Button3.text == a[0]) {
                q++
                table.text = q.toString()
            } else {
                belgi()
            }
        }
        Button4.setOnClickListener {
            if (Button4.text == a[0]) {
                q++
                table.text = q.toString()
            } else {
                belgi()
            }
        }
    }
}

