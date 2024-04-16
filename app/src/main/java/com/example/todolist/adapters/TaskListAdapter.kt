package com.example.todolist.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.entity.PersonalTask

class TaskListAdapter(private var dataset: ArrayList<PersonalTask>): RecyclerView.Adapter<TaskListAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val taskName: TextView
        val taskDateCreated: TextView

        init {
            taskName = view.findViewById(R.id.task_name)
            taskDateCreated = view.findViewById(R.id.task_date)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.task_card,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.taskName.text = dataset.get(position).taskName
        holder.taskDateCreated.text = dataset.get(position).date
    }

    public fun updateData(data: ArrayList<PersonalTask>){
        this.dataset = data
    }
}