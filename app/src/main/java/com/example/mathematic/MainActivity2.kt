package com.example.mathematic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathematic.data.MyDao
import com.example.mathematic.data.MyDataBase
import com.example.mathematic.data.User
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private var natiyje: Int = 0
    private var mAdapter = MyAdapter()
    private lateinit var dao: MyDao
    private var user: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        natiyje = intent.getIntExtra("durisjuwap", 0)
        juwap.text = "${natiyje}"
        user = intent.getStringExtra("username").toString()

        buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        buttonResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("userName", user)
            startActivity(intent)
        }

        dao = MyDataBase.getInstance(this).resultDao()
        var userAdd = dao.getAllResult()

        if (userAdd.isEmpty()) {
            var user = User(name = user, score = natiyje)
            dao.insert(user)
            return
        }else {

            for (i in userAdd.indices) {
                if (userAdd[i].name == user && userAdd[i].score < natiyje) {
                    userAdd[i].score = natiyje
                    dao.updateUser(userAdd[i])
                    return
                } else if (userAdd[i].name == user && userAdd[i].score >= natiyje) {
                    dao.updateUser(userAdd[i])
                    return
                }
            }
        }
        var user = User(name = user,score = natiyje)
        dao.insert(user)
    }
}