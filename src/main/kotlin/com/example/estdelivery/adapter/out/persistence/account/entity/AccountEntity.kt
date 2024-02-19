package com.example.estdelivery.adapter.out.persistence.account.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "account")
class AccountEntity(
    userId: Long,
    accountNumber: String,
    balance: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    var userId: Long = userId
        protected set

    var accountNumber: String = accountNumber
        protected set

    var balance: BigDecimal = balance
        protected set

    fun updateBalance(amount: BigDecimal) {
        balance += amount
    }
}
