package com.example.todolist.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.databinding.TaskCardBinding
import com.example.todolist.entity.PersonalTask
import com.example.todolist.interfaces.ItemClickListener

class TaskListAdapter(private var dataset: ArrayList<PersonalTask>, private val itemClickListener: ItemClickListener): RecyclerView.Adapter<TaskListAdapter.ViewHolder>(){

    inner class ViewHolder(private val taskCardBinding: TaskCardBinding): RecyclerView.ViewHolder(taskCardBinding.root){
        init {
            taskCardBinding.root.setOnClickListener {
                itemClickListener.onTaskClicked(adapterPosition)
            }
        }

        fun bind(personalTask: PersonalTask){
            taskCardBinding.taskName.text = personalTask.taskName.toString()
            taskCardBinding.taskDate.text = personalTask.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val taskCardBinding = TaskCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(taskCardBinding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(dataset[position])
    }

    public fun updateData(data: ArrayList<PersonalTask>){
        this.dataset = data
    }
}