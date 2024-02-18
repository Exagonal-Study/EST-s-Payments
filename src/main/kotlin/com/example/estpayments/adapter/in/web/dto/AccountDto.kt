package com.example.estpayments.adapter.`in`.web.dto

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.domain.model.UserId
import com.example.estpayments.application.port.`in`.command.AccountCreateCommand

data class AccountResponse(
    val id: Long,
    val userId: Long,
    val balance: Long
) {
    companion object {
        fun from(account: Account): AccountResponse =
            AccountResponse(id = account.id.value, userId = account.userId.value, balance = account.balance.value)
    }
}

data class AccountCreateRequest(
    val userId: Long
) {
    fun toCommand(): AccountCreateCommand = AccountCreateCommand(userId = UserId(userId))
}

data class AccountCreateResponse(
    val id: Long,
    val userId: Long,
    val balance: Long
) {
    companion object {
        fun from(account: Account): AccountCreateResponse =
            AccountCreateResponse(id = account.id.value, userId = account.userId.value, balance = account.balance.value)
    }
}