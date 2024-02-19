package com.example.estdelivery.application.port.`in`

import java.math.BigDecimal
import java.time.LocalDateTime

interface ProcessTransactionUseCase {
    fun process(
        senderId: Long,
        senderAccountId: Long,
        receiverId: Long,
        receiverAccountId: Long,
        amount: BigDecimal
    ): BigDecimal
}