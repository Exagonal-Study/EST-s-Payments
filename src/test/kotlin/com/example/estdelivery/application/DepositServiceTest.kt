package com.example.estdelivery.application

import com.example.estdelivery.accountArbitraryBuilder
import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.application.port.`in`.command.DepositCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.depositCommandArbitraryBuilder
import com.example.estdelivery.domain.AccountTransactions
import com.example.estdelivery.moneyArbitraryBuilder
import com.navercorp.fixturemonkey.kotlin.set
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
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
        val money = moneyArbitraryBuilder().sample()
        val accountNumber = accountNumberArbitraryBuilder().sample()
        val depositCommand = depositCommandArbitraryBuilder()
            .set(DepositCommand::accountNumber, accountNumber)
            .set(DepositCommand::amount, money)
            .sample()
        val account = accountArbitraryBuilder()
            .set("accountNumber", accountNumber)
            .set("transactions", AccountTransactions())
            .sample()

        // when
        every { loadAccountPort.findByAccountNumber(depositCommand.accountNumber) } returns account
        every { updateAccountPort.update(account) } returns Unit

        depositService.deposit(depositCommand)

        // then
        account.balance() shouldBe money
    }
})
