package com.example.estdelivery.application

import com.example.estdelivery.accountArbitraryBuilder
import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.application.port.`in`.command.TransferCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.domain.AccountTransactions
import com.example.estdelivery.domain.Money
import com.example.estdelivery.moneyArbitraryBuilder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDateTime

class TransferServiceTest : FreeSpec({

    lateinit var updateAccountPort: UpdateAccountPort
    lateinit var loadAccountPort: LoadAccountPort
    lateinit var transferService: TransferService

    beforeTest {
        updateAccountPort = mockk<UpdateAccountPort>()
        loadAccountPort = mockk<LoadAccountPort>()
        transferService = TransferService(loadAccountPort, updateAccountPort)
    }

    "계좌 간 돈을 이체한다." {
        // given
        val money = moneyArbitraryBuilder().sample()
        val sourceAccountNumber = accountNumberArbitraryBuilder().sample()
        val targetAccountNumber = accountNumberArbitraryBuilder().sample()
        val sourceAccount = accountArbitraryBuilder()
            .set("accountNumber", sourceAccountNumber)
            .set("transactions", AccountTransactions())
            .sample()
        val targetAccount = accountArbitraryBuilder()
            .set("accountNumber", targetAccountNumber)
            .set("transactions", AccountTransactions())
            .sample()

        sourceAccount.deposit(money, LocalDateTime.now().minusDays(1))
        val transferCommand = TransferCommand(
            sourceAccountNumber,
            targetAccountNumber,
            money,
            LocalDateTime.now()
        )

        // when
        every { loadAccountPort.findByAccountNumber(transferCommand.source) } returns sourceAccount
        every { loadAccountPort.findByAccountNumber(transferCommand.target) } returns targetAccount
        every { updateAccountPort.update(sourceAccount) } returns Unit
        every { updateAccountPort.update(targetAccount) } returns Unit

        transferService.transfer(transferCommand)

        // then
        sourceAccount.balance() shouldBe Money.ZERO
        targetAccount.balance() shouldBe transferCommand.amount
    }
})
