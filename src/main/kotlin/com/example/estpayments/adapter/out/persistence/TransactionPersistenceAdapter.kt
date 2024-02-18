package com.example.estpayments.adapter.out.persistence

import com.example.estpayments.application.domain.model.Transaction
import com.example.estpayments.application.domain.model.TransactionStatus
import com.example.estpayments.application.port.out.TransactionCreatePort
import com.example.estpayments.application.port.out.TransactionFindPort
import com.example.estpayments.application.port.out.TransactionUpdatePort
import com.example.estpayments.common.annotation.PersistenceAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

@PersistenceAdapter
class TransactionPersistenceAdapter(
    private val transactionRepository: TransactionRepository
) : TransactionCreatePort, TransactionFindPort, TransactionUpdatePort {
    @Transactional
    override fun create(
        transaction: Transaction
    ): Transaction =
        TransactionMapper.toTransaction(
            transactionRepository.save(TransactionMapper.toTransactionEntity(transaction))
        )

    @Transactional(readOnly = true)
    override fun get(
        id: Long
    ): Transaction =
        TransactionMapper.toTransaction(
            transactionRepository.findByIdOrNull(id)
                ?: throw IllegalArgumentException("not exists transaction.")
        )

    @Transactional(readOnly = true)
    override fun isPending(senderAccountId: Long, receiverAccountId: Long): Boolean =
        transactionRepository.existsBySenderAccountIdAndReceiverAccountIdAndStatus(
            senderAccountId,
            receiverAccountId,
            TransactionStatus.PENDING
        )

    @Transactional
    override fun completed(id: Long) {
        val transactionEntity = transactionRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("not exists transaction.")
        transactionEntity.completed()
    }

    @Transactional
    override fun failed(id: Long) {
        val transactionEntity = transactionRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("not exists transaction.")
        transactionEntity.failed()
    }
}
