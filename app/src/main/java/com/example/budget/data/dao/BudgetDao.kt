package com.example.budget.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.budget.data.entities.Budget

@Dao
interface BudgetDao {
    @Insert
    suspend fun insert(budget: Budget)

    @Query("SELECT * FROM budgets WHERE userId = :userId")
    suspend fun getBudgetsForUser(userId: Long): List<Budget>
}
