package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapters.TaskListAdapter
import com.example.todolist.entity.PersonalTask
import com.example.todolist.viewmodel.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListFragment: Fragment(R.layout.task_list) {

    companion object{
        const val TAG: String = "TaskListFragment"
    }


    private lateinit var taskViewModel: TaskViewModel
    private lateinit var recyclerViewTaskList: RecyclerView
    private lateinit var taskListAdapter: TaskListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val floatingActionButton: FloatingActionButton = view.findViewById(R.id.floating_action_button)
        recyclerViewTaskList = view.findViewById(R.id.task_list_recycler_view)
        recyclerViewTaskList.layoutManager = LinearLayoutManager(context)

        val navContoller = findNavController()

        taskViewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)
        taskListAdapter = TaskListAdapter(this.taskViewModel.getTaskList())
        recyclerViewTaskList.adapter = taskListAdapter

        taskViewModel.data.observe(viewLifecycleOwner){ data ->
            taskListAdapter.updateData(data)
        }

        floatingActionButton.setOnClickListener { e ->
            navContoller.navigate(R.id.action_taskListFragment_to_createTaskFragment)
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}