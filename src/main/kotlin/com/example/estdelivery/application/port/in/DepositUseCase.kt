package com.example.estdelivery.application.port.`in`

import com.example.estdelivery.application.port.`in`.command.DepositCommand

interface DepositUseCase {
    /**
     * 계좌에 돈을 입금한다.
     * @param command
     */
    fun deposit(command: DepositCommand) : AccountResponse
}
