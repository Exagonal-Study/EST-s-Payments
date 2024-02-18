package com.example.estdelivery.application.port.out.persistence.entity

import com.example.estdelivery.domain.AccountNumber
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "account")
class AccountEntity(
    @Embedded
    val accountNumber: AccountNumber,
    @OneToMany
    @JoinColumn(name = "account_id")
    val transferHistories: List<TransferHistoryEntity>,
    @OneToMany
    @JoinColumn(name = "account_id")
    val transactions: List<AccountTransactionEntity>,
    val createdDate: LocalDateTime,
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
