package com.example.estdelivery.application.port.out.persistence.infra

import com.example.estdelivery.application.port.out.persistence.entity.AccountEntity
import com.example.estdelivery.domain.AccountNumber
import org.springframework.data.jpa.repository.JpaRepository

interface AccountEntityRepository: JpaRepository<AccountEntity, Long> {
    fun existsByAccountNumber(accountNumber: AccountNumber): Boolean
    fun findByAccountNumber(accountNumber: AccountNumber): AccountEntity?
}
