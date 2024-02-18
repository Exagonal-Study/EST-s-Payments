package com.example.estdelivery.domain

import java.time.LocalDateTime

class Transfer(
    private val source: Account,
    private val target: Account,
    private val amount: Money,
    private val transactionTime: LocalDateTime
) {
    fun transfer() {
        Withdrawal(source, amount, transactionTime).withdraw()
        Deposit(target, amount, transactionTime).deposit()
    }
}
