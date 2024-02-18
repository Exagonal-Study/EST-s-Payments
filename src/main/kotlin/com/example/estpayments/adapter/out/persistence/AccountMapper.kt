package com.example.estpayments.adapter.out.persistence

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.domain.model.AccountId
import com.example.estpayments.application.domain.model.Money
import com.example.estpayments.application.domain.model.UserId
import com.example.estpayments.common.Constant.INITIAL_BALANCE


object AccountMapper {
    fun toAccount(accountEntity: AccountEntity): Account =
        Account(
            id = AccountId(accountEntity.id!!),
            userId = UserId(accountEntity.userId),
            balance = Money(INITIAL_BALANCE)
        )
}
