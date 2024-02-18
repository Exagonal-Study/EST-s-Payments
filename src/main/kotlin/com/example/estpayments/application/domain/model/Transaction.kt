package com.example.estpayments.application.domain.model

import java.time.LocalDateTime

data class Transaction(
    val id: TransactionId? = null,
    val senderAccountId: AccountId,
    val receiverAccountId: AccountId,
    val amount: Money,
    val transactionDate: LocalDateTime? = LocalDateTime.now(),
    var status: TransactionStatus? = TransactionStatus.PENDING
) {
    fun initial() {
        status = TransactionStatus.PENDING
    }
}

enum class TransactionStatus {
    PENDING, COMPLETED, FAILED
}
