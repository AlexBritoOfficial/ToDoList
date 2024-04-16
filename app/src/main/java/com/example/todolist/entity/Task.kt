package com.example.todolist.entity

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import java.util.UUID

abstract class Task(taskName: String?, taskDescription: String?) {

    val taskId: String = UUID.randomUUID().toString()

    var taskName: String? = taskName
        set(value) {
            value
        }
    var taskDescription: String? = taskDescription
        set(value) {
            value
        }

    var complete: Boolean = false
        set(value) {
            value
        }

    val date: String = Calendar.getInstance().time.toString()

    val taskList: ArrayList<PersonalTask> = ArrayList()
}