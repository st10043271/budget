package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "debts",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Debt(
    @PrimaryKey(autoGenerate = true) val debtId: Long = 0,
    val userId: Long,
    val name: String,
    val initialAmount: Double,
    val currentAmount: Double,
    val interestRate: Double? = null,
    val minimumPayment: Double,
    val dueDate: Int,
    val payoffStrategy: String
)
