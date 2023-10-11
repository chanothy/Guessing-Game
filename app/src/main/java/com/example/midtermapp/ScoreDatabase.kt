package com.example.midtermapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Implementation of the database
 */
@Database(entities = [Score::class], version = 3, exportSchema = false)
abstract class ScoreDatabase : RoomDatabase() {
    abstract val scoreDao: ScoreDao
    companion object {
        @Volatile
        private var INSTANCE: ScoreDatabase? = null
        fun getInstance(context: Context): ScoreDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ScoreDatabase::class.java,
                        "tasks_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}