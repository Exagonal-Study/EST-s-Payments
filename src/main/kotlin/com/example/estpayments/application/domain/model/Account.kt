package com.example.estpayments.application.domain.model

data class Account(
    val id: AccountId,
    val userId: UserId,
    var balance: Money,
) {
    fun withdrawable(money: Money): Boolean = balance.isPositive() && balance.isGreaterThan(money)

    fun withdraw(money: Money) {
        balance = balance.minus(money)
    }

    fun deposit(money: Money) {
        balance = balance.plus(money)
    }
}