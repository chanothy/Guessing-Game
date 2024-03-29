package com.example.midtermapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermapp.databinding.TaskItemBinding

/**
 * communicates between database and viewModel so that the [ScoreFragment] can show
 * the scores in the recycler view
 *
 */

class ScoreItemAdapter(val clickListener: (taskId: Long) -> Unit,
                       val deleteClickListener: (taskId: Long) -> Unit)
    : ListAdapter<Score, ScoreItemAdapter.TaskItemViewHolder>(ScoreDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener, deleteClickListener)
    }

    class TaskItemViewHolder(val binding: TaskItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Score, clickListener: (taskId: Long) -> Unit,
                 deleteClickListener: (taskId: Long) -> Unit) {
            binding.score = item
            binding.root.setOnClickListener { clickListener(item.taskId) }
            binding.deleteButton.setOnClickListener { deleteClickListener(item.taskId) }
        }
    }
}