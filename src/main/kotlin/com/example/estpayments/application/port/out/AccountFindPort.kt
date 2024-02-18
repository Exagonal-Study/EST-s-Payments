package com.example.estpayments.application.port.out

import com.example.estpayments.application.domain.model.Account

interface AccountFindPort {
    fun get(id: Long): Account
}
