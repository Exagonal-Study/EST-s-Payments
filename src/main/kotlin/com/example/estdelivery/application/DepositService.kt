package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.DepositUseCase
import com.example.estdelivery.application.port.`in`.command.DepositCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.domain.Deposit

class DepositService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : DepositUseCase {
    /**
     * 1. 계좌를 조회한다.
     * 2. 계좌에 입금한다.
     * 3. 계좌 정보를 업데이트한다.
     *
     * @param command 입금 명령
     */
    override fun deposit(command: DepositCommand) {
        val account = loadAccountPort.findByAccountNumber(command.accountNumber)
        val depositCommand = Deposit(account, command.amount, command.depositTime)
        depositCommand.deposit()
        updateAccountPort.update(account)
    }
}
