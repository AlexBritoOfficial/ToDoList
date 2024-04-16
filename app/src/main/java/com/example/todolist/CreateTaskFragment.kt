package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.entity.PersonalTask
import com.example.todolist.entity.ProfessionalTask
import com.example.todolist.viewmodel.TaskViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class CreateTaskFragment : Fragment(R.layout.create_new_task) {

    companion object {
        const val TAG: String = "CreateTaskFragment"
    }

    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskViewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)
        val taskNameTextInputLayout = view.findViewById<TextInputLayout>(R.id.taskNameTextInputLayout)
        val taskDescriptionTextInputLayout = view.findViewById<TextInputLayout>(R.id.taskDescriptionTextInputLayout)
        val createButton = view.findViewById<MaterialButton>(R.id.createButton)

        createButton.setOnClickListener { e ->
            taskViewModel.processFormData(taskNameTextInputLayout.editText?.text.toString(),taskDescriptionTextInputLayout.editText?.text.toString())
            findNavController().navigate(R.id.action_createTaskFragment_to_taskListFragment)
        }

    }
}