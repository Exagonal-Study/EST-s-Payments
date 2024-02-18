package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.AccountResponse
import com.example.estdelivery.application.port.`in`.WithdrawUseCase
import com.example.estdelivery.application.port.`in`.command.WithdrawCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.domain.Withdrawal
import org.springframework.stereotype.Service

@Service
class WithdrawService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : WithdrawUseCase {
    /**
     * 1. 계좌를 조회한다.
     * 2. 계좌에서 출금한다.
     * 3. 계좌 정보를 업데이트한다.
     *
     * @param command 출금 명령
     */
    override fun withdraw(command: WithdrawCommand): AccountResponse {
        val account = loadAccountPort.findByAccountNumber(command.accountNumber)
        val withdrawalCommand = Withdrawal(account, command.amount, command.withdrawalTime)
        withdrawalCommand.withdraw()
        updateAccountPort.update(account)
        return AccountResponse(account.balance())
    }
}
