package com.example.estdelivery.application.port.`in`

import com.example.estdelivery.application.port.`in`.command.WithdrawCommand

interface WithdrawUseCase {
    /**
     * 돈을 출금한다. 계좌 잔액은 출금 금액보다 많거나 같아야 한다.
     *
     * @param command 출금 명령
     */
    fun withdraw(command: WithdrawCommand) : AccountResponse
}
