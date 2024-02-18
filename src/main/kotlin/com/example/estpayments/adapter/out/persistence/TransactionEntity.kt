package com.example.estpayments.adapter.out.persistence

import com.example.estpayments.application.domain.model.TransactionStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "transaction")
class TransactionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val senderAccountId: Long,
    val receiverAccountId: Long,
    val amount: Long,
    val transactionDate: LocalDateTime,
    @Enumerated(EnumType.STRING)
    var status: TransactionStatus
) : BaseTimeEntity() {
    fun completed() {
        status = TransactionStatus.COMPLETED
    }

    fun failed() {
        status = TransactionStatus.FAILED
    }
}