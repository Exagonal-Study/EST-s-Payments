package com.example.estdelivery.application.port.`in`

import com.example.estdelivery.application.port.`in`.command.TransferCommand

interface TransferUseCase {
    /**
     * 계좌 간 돈을 이체한다. 이체할 계좌 잔액은 이체할 금액보다 많아야 한다.
     * @param command
     */
    fun transfer(command: TransferCommand) : AccountResponse
}
