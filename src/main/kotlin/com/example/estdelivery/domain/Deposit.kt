package com.example.estdelivery.domain

import java.time.LocalDateTime

class Deposit(
    private val account: Account,
    private val amount: Money,
    private val transactionTime: LocalDateTime
) {
    fun deposit() {
        account.deposit(amount, transactionTime)
    }
}
