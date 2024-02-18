package com.example.estpayments.application.port.out

import com.example.estpayments.application.domain.model.Transaction

interface TransactionFindPort {
    fun get(id: Long): Transaction
    fun isPending(
        senderAccountId: Long,
        receiverAccountId: Long
    ): Boolean
}
