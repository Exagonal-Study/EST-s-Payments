package com.example.estdelivery.application.port.out.persistence

import com.example.estdelivery.application.port.out.CreateAccountPort
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.application.port.out.persistence.mapper.fromAccountEntity
import com.example.estdelivery.application.port.out.persistence.mapper.toAccountEntity
import com.example.estdelivery.application.port.out.persistence.infra.AccountEntityRepository
import com.example.estdelivery.domain.Account
import com.example.estdelivery.domain.AccountNumber
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class AccountAdapter(
    private val accountEntityRepository: AccountEntityRepository
) : CreateAccountPort, LoadAccountPort, UpdateAccountPort {
    @Transactional
    override fun create(account: Account) {
        accountEntityRepository.save(toAccountEntity(account))
    }

    @Transactional
    override fun update(account: Account) {
        accountEntityRepository.save(toAccountEntity(account))
    }

    override fun existsByAccountNumber(accountNumber: AccountNumber) =
        accountEntityRepository.existsByAccountNumber(accountNumber)

    override fun findByAccountNumber(accountNumber: AccountNumber) =
        fromAccountEntity(
            accountEntityRepository.findByAccountNumber(accountNumber) ?: throw NoSuchElementException("Account not found")
        )
}
