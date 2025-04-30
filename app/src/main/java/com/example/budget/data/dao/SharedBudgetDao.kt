package com.example.budget.data.dao

import androidx.room.*
import com.example.budget.data.entities.SharedBudget

@Dao
interface SharedBudgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSharedBudget(sharedBudget: SharedBudget)

    @Query("SELECT * FROM shared_budgets WHERE budgetId = :budgetId")
    suspend fun getUsersInSharedBudget(budgetId: Long): List<SharedBudget>
}
