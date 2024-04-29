package com.example.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.entity.PersonalTask

class SharedTaskViewModel() : ViewModel() {
    private lateinit var personalTask : PersonalTask

    init {
        this.personalTask = PersonalTask(null,null)
        this.personalTask.taskList.add(PersonalTask("Clean","Room"))
    }

    private var _data = MutableLiveData<ArrayList<PersonalTask>>()
    val data : LiveData<ArrayList<PersonalTask>> = _data

    fun processFormData(taskName: String, taskDescription: String){
        this.personalTask.taskList.add(PersonalTask(taskName, taskDescription))
        _data = MutableLiveData(this.personalTask.taskList)
    }

    fun getTaskList(): ArrayList<PersonalTask>{
        return this.personalTask.taskList
    }

}