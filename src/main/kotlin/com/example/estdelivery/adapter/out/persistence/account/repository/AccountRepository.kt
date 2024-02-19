package com.example.estdelivery.adapter.out.persistence.account.repository

import com.example.estdelivery.adapter.out.persistence.account.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, Long> {
    fun findByIdAndUserId(id: Long, userId: Long): AccountEntity
}