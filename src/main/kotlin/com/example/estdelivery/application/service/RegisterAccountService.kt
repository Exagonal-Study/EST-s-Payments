package com.example.estdelivery.application.service

import com.example.estdelivery.application.port.out.AccountPersistencePort
import com.example.estdelivery.application.port.`in`.RegisterAccountUseCase
import com.example.estdelivery.application.utils.AccountNumberGenerator
import com.example.estdelivery.domain.Account
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class RegisterAccountService(
    private val accountPersistencePort: AccountPersistencePort
) : RegisterAccountUseCase {
    override fun registerAccount(userId: Long) {
        val accountNumber = AccountNumberGenerator.generate()
        val initialBalance = BigDecimal.ZERO

        val account = Account(userId, accountNumber, initialBalance)
        accountPersistencePort.registerAccount(account)
    }
}