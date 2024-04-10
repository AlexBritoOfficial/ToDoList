package com.example.todolist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.todolist.entity.PersonalTask

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val TAG : String = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<TaskListFragment>(R.id.main_fragment_container_view)
            }
        }

    }
}