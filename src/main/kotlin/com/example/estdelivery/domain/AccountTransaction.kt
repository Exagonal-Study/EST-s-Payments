package com.example.estdelivery.domain

import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

data class AccountTransaction(
    val amount: Money,
    val type: TransactionType,
    @field:PastOrPresent
    val transactionDateTime: LocalDateTime,
) {
    fun showAmount() = amount
    fun showTransactionTime() = transactionDateTime
    fun showType() = type
}
