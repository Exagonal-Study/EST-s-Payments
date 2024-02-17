package com.example.estdelivery.domain

import jakarta.validation.constraints.PositiveOrZero
import java.math.BigInteger

data class Money(
    @field:PositiveOrZero
    private val amount: BigInteger
) {
    init {
        require(amount >= BigInteger.ZERO) { "금액은 0원 이상이어야 합니다." }
    }

    companion object {
        val ZERO: Money = Money(BigInteger.ZERO)
    }

    operator fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    operator fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    operator fun compareTo(amount: Money): Int {
        return this.amount.compareTo(amount.amount)
    }
}
