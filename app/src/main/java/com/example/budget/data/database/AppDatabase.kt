package com.example.budget.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.budget.data.dao.*
import com.example.budget.data.entities.*

@Database(
    entities = [
        User::class,
        Budget::class,
        BudgetCategory::class,
        Transaction::class,
        Goal::class,
        Debt::class,
        Achievement::class,
        Receipt::class,
        Notification::class,
        SharedBudget::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun budgetDao(): BudgetDao
    abstract fun categoryDao(): BudgetCategoryDao
    abstract fun transactionDao(): TransactionDao
    abstract fun goalDao(): GoalDao
    abstract fun debtDao(): DebtDao
    abstract fun achievementDao(): AchievementDao
    abstract fun receiptDao(): ReceiptDao
    abstract fun notificationDao(): NotificationDao
    abstract fun sharedBudgetDao(): SharedBudgetDao
}
