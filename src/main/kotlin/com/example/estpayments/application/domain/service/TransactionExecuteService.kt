package com.example.estpayments.application.domain.service

import com.example.estpayments.application.domain.model.Account
import com.example.estpayments.application.port.`in`.TransactionExecuteUseCase
import com.example.estpayments.application.port.`in`.command.TransactionExecuteCommand
import com.example.estpayments.application.port.out.AccountFindPort
import com.example.estpayments.application.port.out.AccountUpdatePort
import com.example.estpayments.application.port.out.TransactionCreatePort
import com.example.estpayments.application.port.out.TransactionFindPort
import com.example.estpayments.application.port.out.TransactionUpdatePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionExecuteService(
    private val accountFindPort: AccountFindPort,
    private val accountUpdatePort: AccountUpdatePort,
    private val transactionCreatePort: TransactionCreatePort,
    private val transactionFindPort: TransactionFindPort,
    private val transactionUpdatePort: TransactionUpdatePort,
) : TransactionExecuteUseCase {
    @Transactional
    override fun execute(command: TransactionExecuteCommand): Account {
        // 계좌 조회
        val senderAccount = accountFindPort.get(command.senderAccountId.value)
        val receiverAccount = accountFindPort.get(command.receiverAccountId.value)

        // 송금 계좌 잔액 확인
        if (!senderAccount.withdrawable(command.amount)) {
            throw IllegalArgumentException("insufficient balance.")
        }

        // 중복 송금 확인
        if (transactionFindPort.isPending(command.senderAccountId.value, command.receiverAccountId.value)) {
            throw IllegalArgumentException("duplicated transaction.")
        }

        // 송금
        val transaction = command.toTransactionDomain()
        transaction.initial()
        val transactionId = transactionCreatePort.create(transaction).id!!

        try {
            senderAccount.withdraw(command.amount)
            receiverAccount.deposit(command.amount)
            accountUpdatePort.updateBalance(senderAccount)
            accountUpdatePort.updateBalance(receiverAccount)

            transactionUpdatePort.completed(transactionId.value)
        } catch (e: Exception) {
            transactionUpdatePort.failed(transactionId.value)
            throw e
        }

        return senderAccount
    }
}