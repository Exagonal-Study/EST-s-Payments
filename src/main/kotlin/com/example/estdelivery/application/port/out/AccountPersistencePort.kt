package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.Account

interface AccountPersistencePort {
    fun updateAccountBalance(account: Account)
    fun registerAccount(account: Account)
}