package com.example.estdelivery.domain

import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

class Account(
    private val number: AccountNumber,
    private val balance: Money,
    private val transferHistories: TransferHistories,
    @field:PastOrPresent
    private val createdDate: LocalDateTime,
    private val id: Long? = null
) {
    init {
        require(transferHistories.ensureMyHistories(number)) { "자신의 이력이 아닌 정보가 존재합니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Account(number=$number, balance=$balance, transferHistories=$transferHistories, createdDate=$createdDate, id=$id)"
    }
}
