package com.example.mathematic.data

import androidx.room.*

@Dao
interface MyDao {
    @Query("SELECT * FROM Result ")
    fun getAllResult() : List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (user:User)

    @Update
    fun updateUser(user: User)

}