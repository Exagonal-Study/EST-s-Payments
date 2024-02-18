package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.Account
import com.example.estdelivery.domain.AccountNumber

interface LoadAccountPort {
    fun existsByAccountNumber(accountNumber: AccountNumber): Boolean
    fun findByAccountNumber(accountNumber: AccountNumber): Account
}
