package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.Account

interface LoadAccountsPort {
    fun loadAccounts(userId: Long): List<Account>
    fun loadAccount(userId: Long, accountId: Long): Account
}