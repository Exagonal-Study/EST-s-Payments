package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.Account

interface CreateAccountPort {
    fun create(account: Account)
}
