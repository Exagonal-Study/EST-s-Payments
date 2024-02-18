package com.example.estpayments.application.port.`in`

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.`in`.command.AccountCreateCommand

interface AccountCreateUseCase {
    fun create(command: AccountCreateCommand): Account
}