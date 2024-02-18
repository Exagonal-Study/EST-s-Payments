package com.example.estpayments.application.domain.model

import com.example.estpayments.common.Constant.ZERO_BALANCE

@JvmInline
value class Money(val value: Long) {
    fun isPositive(): Boolean = value > ZERO_BALANCE

    fun isGreaterThan(money: Money): Boolean = value > money.value

    fun minus(money: Money): Money = Money(value.minus(money.value))

    fun plus(money: Money): Money = Money(value.plus(money.value))
}