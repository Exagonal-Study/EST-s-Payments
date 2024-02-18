package com.example.estpayments.adapter.out.persistence

import com.example.estpayments.application.domain.model.AccountId
import com.example.estpayments.application.domain.model.Money
import com.example.estpayments.application.domain.model.Transaction
import com.example.estpayments.application.domain.model.TransactionId
import java.time.LocalDateTime


object TransactionMapper {
    fun toTransaction(transactionEntity: TransactionEntity): Transaction =
        Transaction(
            id = TransactionId(transactionEntity.id!!),
            senderAccountId = AccountId(transactionEntity.senderAccountId),
            receiverAccountId = AccountId(transactionEntity.receiverAccountId),
            amount = Money(transactionEntity.amount),
            transactionDate = transactionEntity.transactionDate,
            status = transactionEntity.status
        )

    fun toTransactionEntity(transaction: Transaction) = TransactionEntity(
        senderAccountId = transaction.senderAccountId.value,
        receiverAccountId = transaction.receiverAccountId.value,
        amount = transaction.amount.value,
        status = transaction.status!!,
        transactionDate = LocalDateTime.now()
    )
}
