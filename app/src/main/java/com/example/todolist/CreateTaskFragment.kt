package com.example.todolist

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class CreateTaskFragment: Fragment(R.layout.create_new_task) {

    companion object{
        const val TAG: String = "CreateTaskFragment"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState == null){
            val createButton = view.findViewById<MaterialButton>(R.id.createButton)

            createButton.setOnClickListener { e ->
                val taskListFragment = TaskListFragment()
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.main_fragment_container_view, taskListFragment)?.commit()
            }
        }

    }
}