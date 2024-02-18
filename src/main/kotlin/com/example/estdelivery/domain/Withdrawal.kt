package com.example.estdelivery.domain

import java.time.LocalDateTime

class Withdrawal(
    private val account: Account,
    private val amount: Money,
    private val transactionTime: LocalDateTime
) {
    init {
        require(account.balance() >= amount) { "잔액이 부족합니다." }
    }

    fun withdraw() {
        account.withdraw(amount, transactionTime)
    }
}
