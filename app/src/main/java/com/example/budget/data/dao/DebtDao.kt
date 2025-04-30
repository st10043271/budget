package com.example.budget.data.dao

import androidx.room.*
import com.example.budget.data.entities.Debt

@Dao
interface DebtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDebt(debt: Debt)

    @Query("SELECT * FROM debts WHERE userId = :userId")
    suspend fun getDebtsForUser(userId: Long): List<Debt>
}
