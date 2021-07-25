package com.example.mathematic.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM Result ")
    fun getAllResult() : List<User>
}