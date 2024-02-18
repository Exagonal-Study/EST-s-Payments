package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.Account

interface UpdateAccountPort {
    fun update(account: Account)
}
