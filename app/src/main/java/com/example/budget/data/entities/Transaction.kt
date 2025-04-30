package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = com.example.budget.data.entities.User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = com.example.budget.data.entities.BudgetCategory::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Transaction(
    @PrimaryKey(autoGenerate = true) val transactionId: Long = 0,
    val userId: Long,
    val categoryId: Long,
    val amount: Double,
    val description: String,
    val date: Long,
    val type: String,
    val paymentMethod: String,
    val receiptUri: String? = null,
    val isRecurring: Boolean = false,
    val recurringInterval: String? = null,
    val isSynced: Boolean = false
)
