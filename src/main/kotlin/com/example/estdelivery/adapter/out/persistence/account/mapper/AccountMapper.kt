package com.example.estdelivery.adapter.out.persistence.account.mapper

import com.example.estdelivery.adapter.out.persistence.account.entity.AccountEntity
import com.example.estdelivery.domain.Account

fun Account.toEntity(): AccountEntity {
    return AccountEntity(
        userId = this.userId,
        accountNumber = this.accountNumber,
        balance = this.balance
    )
}

fun AccountEntity.toDomain(): Account {
    return Account(
        id = this.id!!,
        userId = this.userId,
        accountNumber = this.accountNumber,
        balance = this.balance
    )
}