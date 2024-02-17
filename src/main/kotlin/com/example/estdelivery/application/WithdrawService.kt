package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.WithdrawUseCase
import com.example.estdelivery.application.port.`in`.command.WithdrawCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort

class WithdrawService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : WithdrawUseCase {
    override fun withdraw(withdrawCommand: WithdrawCommand) {
        TODO("Not yet implemented")
    }
}
