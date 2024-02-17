package com.example.estdelivery.application.port.`in`

import com.example.estdelivery.application.port.`in`.command.CreateAccountCommand

interface CreateAccountUseCase {
    /**
     * 계좌를 생성한다. 생성되는 계좌는 고유하며 잔액은 0원이다.
     * @param createAccountCommand
     */
    fun createAccount(createAccountCommand: CreateAccountCommand)
}
