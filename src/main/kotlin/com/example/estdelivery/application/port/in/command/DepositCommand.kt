package com.example.estdelivery.application.port.`in`.command

import com.example.estdelivery.domain.AccountNumber
import com.example.estdelivery.domain.Money
import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

data class DepositCommand(
    val accountNumber: AccountNumber,
    val amount: Money,
    @field:PastOrPresent
    val depositTime: LocalDateTime
)
