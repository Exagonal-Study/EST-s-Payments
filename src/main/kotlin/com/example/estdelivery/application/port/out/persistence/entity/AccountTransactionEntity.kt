package com.example.estdelivery.application.port.out.persistence.entity

import com.example.estdelivery.domain.Money
import com.example.estdelivery.domain.TransactionType
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class AccountTransactionEntity(
    @Embedded
    val amount: Money,
    @Enumerated(EnumType.STRING)
    val type: TransactionType,
    val transactionDateTime: LocalDateTime,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)
