package com.example.todolist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.viewmodel.SharedTaskViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class CreateTaskFragment : Fragment(R.layout.create_new_task) {

    companion object {
        const val TAG: String = "CreateTaskFragment"
    }

    private lateinit var sharedTaskViewModel: SharedTaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedTaskViewModel = ViewModelProvider(requireActivity()).get(SharedTaskViewModel::class.java)
        val taskNameTextInputLayout = view.findViewById<TextInputLayout>(R.id.taskNameTextInputLayout)
        val taskDescriptionTextInputLayout = view.findViewById<TextInputLayout>(R.id.taskDescriptionTextInputLayout)
        val createButton = view.findViewById<MaterialButton>(R.id.createButton)

        createButton.setOnClickListener { e ->
            sharedTaskViewModel.processFormData(taskNameTextInputLayout.editText?.text.toString(),taskDescriptionTextInputLayout.editText?.text.toString())
            findNavController().navigate(R.id.action_createTaskFragment_to_taskListFragment)
        }

    }
}