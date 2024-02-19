package com.example.estdelivery.adapter.`in`.web.dto.transaction.request

import java.math.BigDecimal
import java.time.LocalDateTime

data class RemitRequest(
    val senderId: Long,
    val senderAccountId: Long,
    val receiverId: Long,
    val receiverAccountId: Long,
    val amount: BigDecimal,
)
