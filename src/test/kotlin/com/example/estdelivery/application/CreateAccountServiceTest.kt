package com.example.estdelivery.application

import com.example.estdelivery.accountCommandArbitraryBuilder
import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.application.port.out.CreateAccountPort
import com.example.estdelivery.application.port.out.GenerateAccountNumberPort
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FreeSpec
import io.mockk.every
import io.mockk.mockk

class CreateAccountServiceTest : FreeSpec({

    lateinit var createAccountPort: CreateAccountPort
    lateinit var generateAccountNumberPort: GenerateAccountNumberPort
    lateinit var createAccountService: CreateAccountService

    beforeTest {
        createAccountPort = mockk<CreateAccountPort>()
        generateAccountNumberPort = mockk<GenerateAccountNumberPort>()
        createAccountService = CreateAccountService(createAccountPort, generateAccountNumberPort)
    }

    "계좌를 생성한다." {
        val accountNumber = accountNumberArbitraryBuilder().sample()
        val accountCommand = accountCommandArbitraryBuilder().sample()

        every { generateAccountNumberPort.generate() } returns accountNumber
        every { createAccountPort.create(any()) } returns Unit

        // then
        shouldNotThrowAny {
            createAccountService.createAccount(accountCommand)
        }
    }
})
