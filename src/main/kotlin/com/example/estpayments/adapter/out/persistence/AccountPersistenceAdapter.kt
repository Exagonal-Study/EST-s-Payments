package com.example.estpayments.adapter.out.persistence

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.out.AccountCreatePort
import com.example.estpayments.application.port.out.AccountFindPort
import com.example.estpayments.application.port.out.AccountUpdatePort
import com.example.estpayments.common.Constant
import com.example.estpayments.common.annotation.PersistenceAdapter
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
) : AccountCreatePort, AccountFindPort, AccountUpdatePort {
    override fun create(userId: Long): Account =
        AccountMapper.toAccount(
            accountRepository.save(
                AccountEntity(
                    userId = userId,
                    balance = Constant.INITIAL_BALANCE
                )
            )
        )

    override fun get(id: Long): Account =
        AccountMapper.toAccount(
            accountRepository.findByIdOrNull(id)
                ?: throw IllegalArgumentException("not exists account.")
        )

    override fun updateBalance(account: Account) {
        val accountEntity = accountRepository.findByIdOrNull(account.id.value)
            ?: throw IllegalArgumentException("not exists account.")
        accountEntity.updateBalance(account.balance.value)
    }
}
