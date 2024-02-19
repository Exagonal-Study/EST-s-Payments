package com.example.estdelivery.application.utils

import java.util.concurrent.atomic.AtomicLong

object AccountNumberGenerator {
    private const val ACCOUNT_NUMBER_LENGTH = 10
    private val lastNumber = AtomicLong(System.currentTimeMillis())

    fun generate(): String {
        val newNumber = lastNumber.incrementAndGet()
        return newNumber.toString().takeLast(ACCOUNT_NUMBER_LENGTH)
    }
}