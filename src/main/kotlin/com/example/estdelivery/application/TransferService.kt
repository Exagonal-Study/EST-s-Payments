package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.TransferUseCase
import com.example.estdelivery.application.port.`in`.command.TransferCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.domain.Transfer

class TransferService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : TransferUseCase {
    /**
     * 1. 두 계좌를 조회한다.
     * 2. 계좌를 이체한다.
     * 3. 계좌 정보를 업데이트한다.
     *
     * @param command 이체 명령
     */
    override fun transfer(command: TransferCommand) {
        val sourceAccount = loadAccountPort.findByAccountNumber(command.source)
        val targetAccount = loadAccountPort.findByAccountNumber(command.target)
        Transfer(sourceAccount, targetAccount, command.amount, command.transferTime).transfer()
        updateAccountPort.update(sourceAccount)
        updateAccountPort.update(targetAccount)
    }
}
