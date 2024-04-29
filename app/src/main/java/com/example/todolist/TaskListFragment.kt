package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapters.TaskListAdapter
import com.example.todolist.databinding.TaskListBinding
import com.example.todolist.interfaces.ItemClickListener
import com.example.todolist.viewmodel.SharedTaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListFragment: Fragment(), ItemClickListener {
    companion object{
        const val TAG: String = "TaskListFragment"
    }

    private lateinit var sharedTaskViewModel: SharedTaskViewModel
    private lateinit var recyclerViewTaskList: RecyclerView
    private lateinit var taskListAdapter: TaskListAdapter
    private var _taskListBinding: TaskListBinding? = null
    private val taskListBinding get() = _taskListBinding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val floatingActionButton: FloatingActionButton = view.findViewById(R.id.floating_action_button)
        recyclerViewTaskList = view.findViewById(R.id.task_list_recycler_view)
        recyclerViewTaskList.layoutManager = LinearLayoutManager(context)

        val navContoller = findNavController()

        sharedTaskViewModel = ViewModelProvider(requireActivity()).get(SharedTaskViewModel::class.java)
        taskListAdapter = TaskListAdapter(this.sharedTaskViewModel.getTaskList(), this)
        recyclerViewTaskList.adapter = taskListAdapter


        sharedTaskViewModel.data.observe(viewLifecycleOwner){ data ->
            taskListAdapter.updateData(data)
        }

        floatingActionButton.setOnClickListener { e ->
            navContoller.navigate(R.id.action_taskListFragment_to_createTaskFragment)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         _taskListBinding = TaskListBinding.inflate(inflater,container,false)
        val view = taskListBinding.root

        view.findViewById<RecyclerView>(R.id.task_list_recycler_view)

        return view
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onTaskClicked(taskPosition: Int) {
        findNavController().navigate(R.id.action_taskListFragment_to_fragment_task_detail)
    }
}