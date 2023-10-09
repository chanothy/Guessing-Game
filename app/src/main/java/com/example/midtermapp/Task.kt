package com.example.midtermapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,
    @ColumnInfo(name = "task_name")
    var playerName: String = "",
    @ColumnInfo(name = "description")
    var playerGuesses: String = ""
)
