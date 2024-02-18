package com.example.estdelivery.application.port.out.persistence.entity

import com.example.estdelivery.domain.AccountNumber
import com.example.estdelivery.domain.Money
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class TransferHistoryEntity(
    @Embedded
    @AttributeOverride(name = "accountNumber", column = Column(name = "source_account_number"))
    val sourceAccountNumber: AccountNumber,
    @Embedded
    @AttributeOverride(name = "accountNumber", column = Column(name = "target_account_number"))
    val targetAccountNumber: AccountNumber,
    @Embedded
    val amount: Money,
    val transferDate: LocalDateTime,
    @Id
    @Column(name = "transfer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
