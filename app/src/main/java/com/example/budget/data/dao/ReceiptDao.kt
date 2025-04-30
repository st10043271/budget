package com.example.budget.data.dao

import androidx.room.*
import com.example.budget.data.entities.Receipt

@Dao
interface ReceiptDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReceipt(receipt: Receipt)

    @Query("SELECT * FROM receipts WHERE transactionId = :transactionId")
    suspend fun getReceiptsForTransaction(transactionId: Long): List<Receipt>
}
