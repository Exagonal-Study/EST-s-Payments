package com.example.estpayments.application.port.out

import com.example.estpayments.application.domain.model.Account

interface AccountCreatePort {
    fun create(userId: Long): Account
}
