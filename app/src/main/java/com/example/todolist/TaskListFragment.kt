package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapters.TaskListAdapter
import com.example.todolist.entity.PersonalTask
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListFragment: Fragment(R.layout.task_list) {

    companion object{
        const val TAG: String = "TaskListFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val floatingActionButton: FloatingActionButton = view.findViewById(R.id.floating_action_button)
        val recyclerViewTaskList: RecyclerView = view.findViewById(R.id.task_list_recycler_view)
        recyclerViewTaskList.layoutManager = LinearLayoutManager(context)

        val list = arrayListOf(PersonalTask("Clean Room", 5), PersonalTask("Work on Android Project",5))
        val taskListAdapter = TaskListAdapter(list)
        recyclerViewTaskList.adapter = taskListAdapter

        floatingActionButton.setOnClickListener { e ->

            Log.d(TAG, "Button Clicked")
            val createTaskFragment = CreateTaskFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.main_fragment_container_view, createTaskFragment)?.commit()
        }
    }
}