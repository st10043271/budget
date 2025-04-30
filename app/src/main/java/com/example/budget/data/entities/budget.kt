package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "budgets",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Budget(
    @PrimaryKey(autoGenerate = true) val budgetId: Long = 0,
    val userId: Long,
    val name: String,
    val monthlyAmount: Double,
    val startDate: Long,
    val isShared: Boolean = false,
    val rolloverEnabled: Boolean = true
)
