package com.example.budget.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "receipts",
    foreignKeys = [
        ForeignKey(
            entity = Transaction::class,
            parentColumns = ["transactionId"],
            childColumns = ["transactionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Receipt(
    @PrimaryKey(autoGenerate = true) val receiptId: Long = 0,
    val transactionId: Long,
    val imageUri: String,
    val extractedText: String? = null,
    val extractionDate: Long? = null,
    val merchantName: String? = null,
    val totalAmount: Double? = null
)
