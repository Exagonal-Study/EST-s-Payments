package com.example.estdelivery.application.port.`in`.command

import com.example.estdelivery.domain.AccountNumber
import com.example.estdelivery.domain.Money
import java.time.LocalDateTime

data class TransferCommand(
    val source: AccountNumber,
    val target: AccountNumber,
    val amount: Money,
    val transferTime: LocalDateTime
)
