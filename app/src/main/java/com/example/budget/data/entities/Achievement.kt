package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "achievements",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Achievement(
    @PrimaryKey(autoGenerate = true) val achievementId: Long = 0,
    val userId: Long,
    val name: String,
    val description: String,
    val earnedDate: Long,
    val iconRes: String,
    val type: String
)
