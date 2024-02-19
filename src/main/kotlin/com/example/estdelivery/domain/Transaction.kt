package com.example.estdelivery.domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val id: Long,
    val senderId: Long,
    val receiverId: Long,
    val amount: BigDecimal,
    val timestamp: LocalDateTime
)
