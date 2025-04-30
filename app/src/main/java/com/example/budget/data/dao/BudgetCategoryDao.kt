package com.example.budget.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.budget.data.entities.BudgetCategory

@Dao
interface BudgetCategoryDao {
    @Insert
    suspend fun insert(category: BudgetCategory)

    @Query("SELECT * FROM budget_categories WHERE budgetId = :budgetId")
    suspend fun getCategoriesForBudget(budgetId: Long): List<BudgetCategory>
}
