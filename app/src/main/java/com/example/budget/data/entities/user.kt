package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Long = 0,
    val fullName: String,
    val username: String,
    val email: String,
    val password: String
)
