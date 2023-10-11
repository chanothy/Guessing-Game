package com.example.midtermapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Schema for the scores item
 */

@Entity(tableName = "task_table")
data class Score(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,
    @ColumnInfo(name = "task_name")
    var taskName: String = "",
    @ColumnInfo(name = "description")
    var description: Int = 0
)
