package com.example.estpayments.application.port.`in`.command

import com.example.estpayments.application.domain.model.AccountId
import com.example.estpayments.application.domain.model.Money
import com.example.estpayments.application.domain.model.Transaction
import com.example.estpayments.application.domain.model.TransactionStatus

data class TransactionExecuteCommand(
    val senderAccountId: AccountId,
    val receiverAccountId: AccountId,
    val amount: Money,
) {
    fun toTransactionDomain(): Transaction = Transaction(
        senderAccountId = senderAccountId,
        receiverAccountId = receiverAccountId,
        amount = amount
    )
}