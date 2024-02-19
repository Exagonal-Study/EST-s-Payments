package com.example.estdelivery.adapter.out.persistence.account.adapter

import com.example.estdelivery.adapter.out.persistence.account.mapper.toDomain
import com.example.estdelivery.adapter.out.persistence.account.mapper.toEntity
import com.example.estdelivery.adapter.out.persistence.account.repository.AccountRepository
import com.example.estdelivery.application.port.out.AccountPersistencePort
import com.example.estdelivery.application.port.out.LoadAccountsPort
import com.example.estdelivery.domain.Account
import org.springframework.stereotype.Component

@Component
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
) : AccountPersistencePort, LoadAccountsPort {
    override fun loadAccount(userId: Long, accountId: Long): Account {
        return accountRepository.findByIdAndUserId(accountId, userId).toDomain()
    }

    override fun loadAccounts(userId: Long): List<Account> {
        TODO()
    }

    override fun updateAccountBalance(account: Account) {
        val accountEntity = accountRepository.findById(account.id!!).orElseThrow {
            throw Exception("account not found")
        }
        accountEntity.updateBalance(account.balance)
    }

    override fun registerAccount(account: Account) {
        accountRepository.save(account.toEntity())
    }
}