package com.example.estpayments.adapter.`in`.web.dto

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.domain.model.AccountId
import com.example.estpayments.application.domain.model.Money
import com.example.estpayments.application.port.`in`.command.TransactionExecuteCommand

data class TransactionExecuteRequest(
    val senderAccountId: Long,
    val receiverAccountId: Long,
    val amount: Long
) {
    fun toCommand(): TransactionExecuteCommand = TransactionExecuteCommand(
        senderAccountId = AccountId(senderAccountId),
        receiverAccountId = AccountId(receiverAccountId),
        amount = Money(amount)
    )
}

data class TransactionExecuteResponse(
    val balance: Long
) {
    companion object {
        fun from(account: Account): TransactionExecuteResponse =
            TransactionExecuteResponse(balance = account.balance.value)
    }
}