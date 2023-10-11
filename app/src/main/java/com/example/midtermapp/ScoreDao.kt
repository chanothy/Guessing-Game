package com.example.midtermapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Functions for the score database
 */
@Dao
interface ScoreDao {
    @Insert
    suspend fun insert(score: Score)
    @Update
    suspend fun update(score: Score)
    @Delete
    suspend fun delete(score: Score)
    @Query("SELECT * FROM task_table WHERE taskId = :key")
    fun get(key: Long): LiveData<Score>
    @Query("SELECT * FROM task_table ORDER BY description ASC")
    fun getAll(): LiveData<List<Score>>
    @Query("SELECT COUNT(*) FROM task_table")
    fun getRowCount(): LiveData<Int>

}