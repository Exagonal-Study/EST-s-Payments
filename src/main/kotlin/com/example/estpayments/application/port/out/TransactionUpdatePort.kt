package com.example.estpayments.application.port.out

interface TransactionUpdatePort {
    fun completed(id: Long)

    fun failed(id: Long)
}
