package com.example.todolist.entity

class ProfessionalRole(roleName:String): Role(roleName) {

    override fun getRole(): String {
        return roleName
    }
}