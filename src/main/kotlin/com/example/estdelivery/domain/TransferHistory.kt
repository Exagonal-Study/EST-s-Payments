package com.example.estdelivery.domain

import jakarta.validation.constraints.PastOrPresent
import java.time.LocalDateTime

data class TransferHistory(
    private val source: AccountNumber,
    private val target: AccountNumber,
    private val money: Money,
    @field:PastOrPresent
    private val transferDate: LocalDateTime
) {
    init {
        require(source != target) { "출금 계좌와 입금 계좌는 같을 수 없습니다." }
    }
}
