package com.example.midtermapp

import androidx.recyclerview.widget.DiffUtil

/**
 * Checks if items are new and updates them
 * Checks if items are old and assigns the the same id and info
 */
class ScoreDiffItemCallback : DiffUtil.ItemCallback<Score>() {
    override fun areItemsTheSame(oldItem: Score, newItem: Score)
            = (oldItem.taskId == newItem.taskId)
    override fun areContentsTheSame(oldItem: Score, newItem: Score) = (oldItem == newItem)
}