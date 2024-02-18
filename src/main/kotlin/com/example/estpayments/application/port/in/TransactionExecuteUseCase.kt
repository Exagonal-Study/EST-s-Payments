package com.example.estpayments.application.port.`in`

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.`in`.command.TransactionExecuteCommand

interface TransactionExecuteUseCase {
    fun execute(command: TransactionExecuteCommand): Account
}