package com.example.todolist.entity

abstract class Role(roleName: String) {

    var roleName: String = roleName

    abstract fun getRole(): String
}