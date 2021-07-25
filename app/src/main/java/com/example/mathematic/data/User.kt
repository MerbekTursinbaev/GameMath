package com.example.mathematic.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mathematic.Result
import java.util.*

@Entity(tableName = "Result")
data class User (
    @PrimaryKey
    val id: Int,
    val name: String,
    val score: Int
        )