package com.example.estdelivery.domain

import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class AccountNumber(
    @field:Size(min = 10, max = 10)
    @field:Pattern(regexp = "^[0-9]*$")
    private val accountNumber: String
) {
    init {
        require(accountNumber.length == 10) { "계좌번호는 10자리여야 합니다." }
    }
}
