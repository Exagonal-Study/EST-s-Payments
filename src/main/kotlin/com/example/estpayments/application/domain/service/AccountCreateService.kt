package com.example.estpayments.application.domain.service

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.`in`.AccountCreateUseCase
import com.example.estpayments.application.port.`in`.command.AccountCreateCommand
import com.example.estpayments.application.port.out.AccountCreatePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountCreateService(
    private val accountCreatePort: AccountCreatePort
) : AccountCreateUseCase {
    @Transactional
    override fun create(command: AccountCreateCommand): Account = accountCreatePort.create(command.userId.value)
}