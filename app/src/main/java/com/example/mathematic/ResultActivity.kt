package com.example.mathematic

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathematic.data.MyDao
import com.example.mathematic.data.MyDataBase
import com.example.mathematic.data.User
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.recycler_view.*
import java.util.prefs.AbstractPreferences

class Result : AppCompatActivity() {

    private val mAdapter = MyAdapter()
    private lateinit var dao: MyDao

    private var currentResult = 0
    private var maxScore = 0
    private var name: String = ""
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        recyclerView.adapter = mAdapter
        currentResult = intent.getIntExtra("durisjuwap", 0)
        name = intent.getStringExtra("username").toString()

        val user = User(
            name = name,
            score = currentResult
        )

        setData()
        dao.insert(user)
        //  maxScore = preferences.getInt("max_score",0)
        //  preferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)

        //  tvResult.text = "$currentResult"
        //  if (currentResult > maxScore) {
        //      preferences.edit().putInt("max_crore",currentResult).apply()
        //  }
        //  tvMaxScore.text = "Max Score is ${preferences.getInt("max_score",0)}"
    }

    private fun setData() {
        dao = MyDataBase.getInstance(this).resultDao()
        mAdapter.models = dao.getAllResult()
    }
}