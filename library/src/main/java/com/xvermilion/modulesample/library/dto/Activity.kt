package com.xvermilion.modulesample.library.dto

interface Activity {
    val id: Int
    val title: String?
    val dueDate: String?
    val completed: Boolean
}