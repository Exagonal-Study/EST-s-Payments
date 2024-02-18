package com.example.estdelivery.application.port.out.persistence

import com.example.estdelivery.application.port.out.GenerateAccountNumberPort
import com.example.estdelivery.application.port.out.persistence.infra.AccountEntityRepository
import com.example.estdelivery.application.port.out.persistence.infra.AccountNumberSequence
import com.example.estdelivery.domain.AccountNumber
import org.springframework.stereotype.Component

@Component
class GenerateAccountNumberAdapter(
    private val accountNumberSequence: AccountNumberSequence,
    private val accountEntityRepository: AccountEntityRepository
) : GenerateAccountNumberPort {
    override fun generate(): AccountNumber {
        var accountNumber: AccountNumber
        do {
            accountNumber = AccountNumber(accountNumberSequence.next())
        } while (accountEntityRepository.existsByAccountNumber(accountNumber))
        return accountNumber
    }
}
