package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.todolist.entity.PersonalTask
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val TAG : String = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            val taskListFragment = TaskListFragment()
            val floatingActionButton = findViewById<FloatingActionButton>(R.id.floating_action_button)
            supportFragmentManager.beginTransaction().add(R.id.main_fragment_container_view, taskListFragment, TaskListFragment.TAG).commit()
        }

    }
}