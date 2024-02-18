package com.example.estdelivery.application.port.`in`.web

import com.example.estdelivery.application.port.`in`.CreateAccountUseCase
import com.example.estdelivery.application.port.`in`.DepositUseCase
import com.example.estdelivery.application.port.`in`.TransferUseCase
import com.example.estdelivery.application.port.`in`.WithdrawUseCase
import com.example.estdelivery.application.port.`in`.command.CreateAccountCommand
import com.example.estdelivery.application.port.`in`.command.DepositCommand
import com.example.estdelivery.application.port.`in`.command.TransferCommand
import com.example.estdelivery.application.port.`in`.command.WithdrawCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
    private val createAccountUseCase: CreateAccountUseCase,
    private val depositUseCase: DepositUseCase,
    private val withdrawUseCase: WithdrawUseCase,
    private val transferUseCase: TransferUseCase
) {
    @PostMapping
    fun createAccount(createAccountCommand: CreateAccountCommand) {
        createAccountUseCase.createAccount(createAccountCommand)
    }

    @PostMapping("/deposit")
    fun deposit(depositCommand: DepositCommand) = depositUseCase.deposit(depositCommand)

    @PostMapping("/withdraw")
    fun withdraw(withdrawCommand: WithdrawCommand) = withdrawUseCase.withdraw(withdrawCommand)

    @PostMapping("/transfer")
    fun transfer(transferCommand: TransferCommand) = transferUseCase.transfer(transferCommand)
}
