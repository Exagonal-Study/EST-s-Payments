package com.example.estdelivery.application.service

import com.example.estdelivery.application.port.`in`.ProcessTransactionUseCase
import com.example.estdelivery.application.port.out.AccountPersistencePort
import com.example.estdelivery.application.port.out.LoadAccountsPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.concurrent.ConcurrentHashMap

@Service
class ProcessTransactionService(
    private val accountPersistencePort: AccountPersistencePort,
//    private val transactionPersistencePort: TransactionPersistencePort,
//    private val userPersistencePort: UserPersistencePort,
    private val loadAccountPort : LoadAccountsPort
) : ProcessTransactionUseCase {

    private val processingTransactions = ConcurrentHashMap<String, Boolean>()

    /*
     * 1. 보내는 사용자의 계좌 정보 조회
     * 2. 받는 사용자의 계좌 정보 조회
     * 3. 보내는 사용자의 계좌에서 출금
     * 4. 받는 사용자의 계좌에 입금
     */
    @Transactional
    override fun process(
        senderId: Long,
        senderAccountId: Long,
        receiverId: Long,
        receiverAccountId: Long,
        amount: BigDecimal
    ): BigDecimal {
        if (processingTransactions.putIfAbsent("${senderId}${receiverId}", true) != null) {
            throw RuntimeException("Processing same transaction")
        }

        try {
            val senderAccount = loadAccountPort.loadAccount(senderId, senderAccountId)
            val receiverAccount = loadAccountPort.loadAccount(receiverId, receiverAccountId)

            senderAccount.withdraw(amount)
            receiverAccount.deposit(amount)

            accountPersistencePort.updateAccountBalance(senderAccount)
            accountPersistencePort.updateAccountBalance(receiverAccount)

            // TODO : 트랜잭션 정보 저장

        } finally {
            processingTransactions.remove("${senderId}${receiverId}")
        }

        return amount
    }
}