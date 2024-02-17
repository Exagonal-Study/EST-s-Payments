package com.example.estdelivery.domain

import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

data class AccountTransaction(
    val amount: Money,
    val type: TransactionType,
    @field:PastOrPresent
    private val transactionDateTime: LocalDateTime,
) {
    init {
        require(transactionDateTime.isBefore(LocalDateTime.now())) { "거래 일자는 현재 시간보다 이전이어야 합니다." }
    }
}
