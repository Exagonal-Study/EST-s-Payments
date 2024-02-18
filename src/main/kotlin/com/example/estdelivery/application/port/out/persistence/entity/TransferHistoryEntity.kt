package com.example.estdelivery.application.port.out.persistence.entity

import com.example.estdelivery.domain.AccountNumber
import com.example.estdelivery.domain.Money
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class TransferHistoryEntity(
    @Embedded
    val sourceAccountNumber: AccountNumber,
    @Embedded
    val targetAccountNumber: AccountNumber,
    @Embedded
    val money: Money,
    val transferDate: LocalDateTime,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}
