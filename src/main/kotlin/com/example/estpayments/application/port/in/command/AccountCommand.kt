package com.example.estpayments.application.port.`in`.command

import com.example.estpayments.application.domain.model.AccountId
import com.example.estpayments.application.domain.model.UserId

data class AccountCreateCommand(val userId: UserId)

data class AccountFindCommand(val id: AccountId)