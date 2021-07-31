package com.example.mathematic.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Result")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var score: Int
)