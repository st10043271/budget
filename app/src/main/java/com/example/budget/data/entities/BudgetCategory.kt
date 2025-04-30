package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "budget_categories",
    foreignKeys = [
        ForeignKey(
            entity = Budget::class,
            parentColumns = ["budgetId"],
            childColumns = ["budgetId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BudgetCategory(
    @PrimaryKey(autoGenerate = true) val categoryId: Long = 0,
    val budgetId: Long,
    val name: String,
    val allocatedAmount: Double,
    val currentAmount: Double,
    val iconRes: String,
    val color: String
)
