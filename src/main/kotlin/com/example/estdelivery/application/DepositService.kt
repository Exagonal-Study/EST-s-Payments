package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.DepositUseCase
import com.example.estdelivery.application.port.`in`.command.DepositCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort

class DepositService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : DepositUseCase {
    override fun deposit(depositCommand: DepositCommand) {
        TODO("Not yet implemented")
    }
}
