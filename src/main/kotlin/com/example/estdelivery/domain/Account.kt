package com.example.estdelivery.domain

import java.math.BigDecimal

data class Account(
    val userId: Long,
    val accountNumber: String,
    var balance: BigDecimal,
    val id: Long? = null
) {
    fun deposit(amount: BigDecimal) {
        balance += amount
    }

    fun withdraw(amount: BigDecimal) {
        balance -= amount
    }
}
