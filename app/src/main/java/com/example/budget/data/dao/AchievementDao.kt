package com.example.budget.data.dao

import androidx.room.*
import com.example.budget.data.entities.Achievement

@Dao
interface AchievementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievement(achievement: Achievement)

    @Query("SELECT * FROM achievements WHERE userId = :userId")
    suspend fun getAchievementsForUser(userId: Long): List<Achievement>
}
