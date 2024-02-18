package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.AccountNumber

interface GenerateAccountNumberPort {
    fun generate(): AccountNumber
}
