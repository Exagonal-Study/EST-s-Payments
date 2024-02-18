package com.example.estpayments.adapter.out.persistence

import com.example.estpayments.application.domain.model.TransactionStatus
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<TransactionEntity, Long> {
    fun existsBySenderAccountIdAndReceiverAccountIdAndStatus(
        senderAccountId: Long,
        receiverAccountId: Long,
        status: TransactionStatus
    ): Boolean
}
