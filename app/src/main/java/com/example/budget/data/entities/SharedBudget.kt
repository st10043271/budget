package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "shared_budgets",
    foreignKeys = [
        ForeignKey(
            entity = Budget::class,
            parentColumns = ["budgetId"],
            childColumns = ["budgetId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["ownerId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["sharedUserId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SharedBudget(
    @PrimaryKey(autoGenerate = true) val sharedBudgetId: Long = 0,
    val budgetId: Long,
    val ownerId: Long,
    val sharedUserId: Long,
    val permissionLevel: String,
    val joinedDate: Long = System.currentTimeMillis()
)
