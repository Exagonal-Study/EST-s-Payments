package com.example.estdelivery.domain

import jakarta.validation.constraints.PositiveOrZero
import java.math.BigInteger

class Money(
    @field:PositiveOrZero
    private val amount: BigInteger
) {
    init {
        require(amount >= BigInteger.ZERO) { "금액은 0원 이상이어야 합니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        return amount == other.amount
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }

    override fun toString(): String {
        return "Money(amount=$amount)"
    }
}
