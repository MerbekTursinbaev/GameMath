package com.example.mathematic.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM Result ")
    fun getAllResult() : List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (user:User)

}