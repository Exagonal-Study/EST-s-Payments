package com.example.estdelivery.application.port.`in`.command

import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

data class CreateAccountCommand(
    @field:PastOrPresent
    val createTime: LocalDateTime
)
