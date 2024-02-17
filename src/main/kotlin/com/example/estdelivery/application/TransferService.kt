package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.TransferUseCase
import com.example.estdelivery.application.port.`in`.command.TransferCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort

class TransferService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : TransferUseCase {
    override fun transfer(transferCommand: TransferCommand) {
        TODO("Not yet implemented")
    }
}
