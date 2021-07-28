package com.example.mathematic.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [User::class], version = 1)
abstract class MyDataBase : RoomDatabase() {

    companion object {
        lateinit var INSTANCE: MyDataBase
        fun getInstance(context: Context): MyDataBase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDataBase::class.java, "Result-database"
                )
                    .allowMainThreadQueries()
                    // .createFromAsset("Result.db")
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun resultDao() : MyDao
}