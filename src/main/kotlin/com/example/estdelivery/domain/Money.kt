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
}
