package com.example.estdelivery.application.port.out.persistence.mapper

import com.example.estdelivery.application.port.out.persistence.entity.AccountEntity
import com.example.estdelivery.application.port.out.persistence.entity.AccountTransactionEntity
import com.example.estdelivery.application.port.out.persistence.entity.TransferHistoryEntity
import com.example.estdelivery.domain.Account
import com.example.estdelivery.domain.AccountTransaction
import com.example.estdelivery.domain.AccountTransactions
import com.example.estdelivery.domain.TransferHistories
import com.example.estdelivery.domain.TransferHistory

fun toAccountEntity(newAccount: Account): AccountEntity {
    return AccountEntity(
        accountNumber = newAccount.showNumber(),
        transferHistories = newAccount.showHistories().map { toTransferHistoryEntity(it) },
        transactions = newAccount.showTransactions().map { toAccountTransactionEntity(it) },
        createdDate = newAccount.showCreatedDate(),
        id = newAccount.id
    )
}

fun fromAccountEntity(accountEntity: AccountEntity): Account {
    return Account(
        number = accountEntity.accountNumber,
        transferHistories = TransferHistories(accountEntity.transferHistories.map { fromTransferHistoryEntity(it) }),
        transactions = AccountTransactions(accountEntity.transactions.map { fromAccountTransactionEntity(it) }),
        createdDate = accountEntity.createdDate,
        id = accountEntity.id
    )
}

private fun toAccountTransactionEntity(it: AccountTransaction) =
    AccountTransactionEntity(
        amount = it.showAmount(),
        type = it.showType(),
        transactionDateTime = it.showTransactionTime()
    )

private fun fromAccountTransactionEntity(it: AccountTransactionEntity) =
    AccountTransaction(
        amount = it.amount,
        type = it.type,
        transactionDateTime = it.transactionDateTime
    )

private fun toTransferHistoryEntity(it: TransferHistory) =
    TransferHistoryEntity(
        money = it.showAmount(),
        sourceAccountNumber = it.showSource(),
        targetAccountNumber = it.showTarget(),
        transferDate = it.showTransferDate()
    )

private fun fromTransferHistoryEntity(it: TransferHistoryEntity) =
    TransferHistory(
        money = it.money,
        source = it.sourceAccountNumber,
        target = it.targetAccountNumber,
        transferDate = it.transferDate
    )

