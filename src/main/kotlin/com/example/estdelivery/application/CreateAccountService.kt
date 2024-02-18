package com.example.estdelivery.application

import com.example.estdelivery.application.port.`in`.CreateAccountUseCase
import com.example.estdelivery.application.port.`in`.command.CreateAccountCommand
import com.example.estdelivery.application.port.out.CreateAccountPort
import com.example.estdelivery.application.port.out.GenerateAccountNumberPort
import com.example.estdelivery.domain.Account
import com.example.estdelivery.domain.AccountTransactions
import com.example.estdelivery.domain.TransferHistories

class CreateAccountService(
    private val createAccountPort: CreateAccountPort,
    private val generateAccountNumber: GenerateAccountNumberPort,
) : CreateAccountUseCase {
    /**
     * 1. 계좌를 생성한다.
     * 2. 계좌 정보를 저장한다.
     */
    override fun createAccount(command: CreateAccountCommand) {
        val accountNumber = generateAccountNumber.generate()
        val newAccount =
            Account(accountNumber, TransferHistories(), AccountTransactions(), command.createTime)
        createAccountPort.create(newAccount)
    }
}
