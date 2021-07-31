package com.example.mathematic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathematic.data.MyDao
import com.example.mathematic.data.MyDataBase
import com.example.mathematic.data.User
import kotlinx.android.synthetic.main.recycler_view.*

class ResultActivity : AppCompatActivity() {

    private lateinit var dao: MyDao
    private var mAdapter = MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        recyclerView.adapter = mAdapter
        setData()
    }
    fun setData() {
        dao = MyDataBase.getInstance(this).resultDao()
        mAdapter.models = dao.getAllResult()
    }
}