package com.example.mathematic.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class MyDataBase : RoomDatabase() {

}