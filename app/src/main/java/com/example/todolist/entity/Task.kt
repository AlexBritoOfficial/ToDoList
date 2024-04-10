package com.example.todolist.entity

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import java.util.UUID

abstract class Task (taskName: String, priority: Int) {

    val taskId: String = UUID.randomUUID().toString()
        get() = field

    var priority: Int = priority
        get() = field
        set(value) {
            if (value > 0) {
                value
            }
            else {
                0
            }
        }

    var taskName: String = taskName
        get() = field
        set(value) {
            value
        }

    var complete: Boolean = false
        get() = field
        set(value) {
            value
        }

    val date: String = Calendar.getInstance().time.toString()
        get() = field
}