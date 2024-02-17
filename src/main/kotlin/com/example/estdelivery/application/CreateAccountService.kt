package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.CreateAccountUseCase
import com.example.estdelivery.application.port.`in`.command.CreateAccountCommand
import com.example.estdelivery.application.port.out.CreateAccountPort
import com.example.estdelivery.application.port.out.LoadAccountPort

class CreateAccountService(
    private val loadAccountPort: LoadAccountPort,
    private val createAccountPort: CreateAccountPort
) : CreateAccountUseCase {
    override fun createAccount(createAccountCommand: CreateAccountCommand) {
        TODO("Not yet implemented")
    }
}
