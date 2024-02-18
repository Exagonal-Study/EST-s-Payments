package com.example.estdelivery.domain

import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

class Account(
    private val number: AccountNumber,
    private val transferHistories: TransferHistories,
    private val transactions: AccountTransactions,
    @field:PastOrPresent
    private val createdDate: LocalDateTime,
    val id: Long? = null
) {
    fun balance() = transactions.balance()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        return id == other.id
    }

    override fun hashCode() = id?.hashCode() ?: 0

    override fun toString() =
        "Account(number=$number, balance=${balance()}, transferHistories=$transferHistories, createdDate=$createdDate, id=$id)"

    fun deposit(amount: Money, transactionTime: LocalDateTime) {
        transactions.deposit(amount, transactionTime)
    }

    fun withdraw(amount: Money, transactionTime: LocalDateTime) {
        transactions.withdraw(amount, transactionTime)
    }

    fun showTransactions() = transactions.showTransactions()
    fun showHistories() = transferHistories.showHistories()
    fun showNumber() = number
    fun showCreatedDate() = createdDate
}
