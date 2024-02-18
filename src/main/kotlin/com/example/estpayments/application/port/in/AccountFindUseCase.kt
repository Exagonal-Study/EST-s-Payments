package com.example.estpayments.application.port.`in`

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.`in`.command.AccountCreateCommand
import com.example.estpayments.application.port.`in`.command.AccountFindCommand

interface AccountFindUseCase {
    fun get(command: AccountFindCommand): Account
}