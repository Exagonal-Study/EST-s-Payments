package com.example.estpayments.application.domain.service

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.`in`.AccountFindUseCase
import com.example.estpayments.application.port.`in`.command.AccountFindCommand
import com.example.estpayments.application.port.out.AccountFindPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountFindService(
    private val accountFindPort: AccountFindPort
) : AccountFindUseCase {
    @Transactional(readOnly = true)
    override fun get(command: AccountFindCommand): Account = accountFindPort.get(command.id.value)
}