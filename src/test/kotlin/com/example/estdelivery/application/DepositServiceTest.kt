package com.example.estdelivery.application

import com.example.estdelivery.accountArbitraryBuilder
import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.application.port.`in`.command.DepositCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.depositCommandArbitraryBuilder
import com.navercorp.fixturemonkey.kotlin.set
import io.kotest.core.spec.style.FreeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class DepositServiceTest : FreeSpec({

    lateinit var updateAccountPort: UpdateAccountPort
    lateinit var loadAccountPort: LoadAccountPort
    lateinit var depositService: DepositService

    beforeTest {
        updateAccountPort = mockk<UpdateAccountPort>()
        loadAccountPort = mockk<LoadAccountPort>()
        depositService = DepositService(loadAccountPort, updateAccountPort)
    }

    "계좌에 돈을 입금한다." {
        // given
        val accountNumber = accountNumberArbitraryBuilder().sample()
        val depositCommand = depositCommandArbitraryBuilder()
            .set(DepositCommand::accountNumber, accountNumber)
            .sample()
        val account = accountArbitraryBuilder()
            .set("accountNumber", accountNumber)
            .sample()

        // when
        every { loadAccountPort.findByAccountNumber(depositCommand.accountNumber) } returns account
        every { updateAccountPort.update(account) } returns Unit

        depositService.deposit(depositCommand)

        // then
        verify(exactly = 1) { updateAccountPort.update(account) }
    }

})
