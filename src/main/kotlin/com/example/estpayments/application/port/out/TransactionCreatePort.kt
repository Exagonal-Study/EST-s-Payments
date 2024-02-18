package com.example.estpayments.application.port.out

import com.example.estpayments.application.domain.model.Transaction

interface TransactionCreatePort {
    fun create(transaction: Transaction): Transaction
}
