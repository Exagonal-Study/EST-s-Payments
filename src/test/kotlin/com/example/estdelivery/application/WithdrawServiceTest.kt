package com.example.estdelivery.application

import com.example.estdelivery.accountArbitraryBuilder
import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.application.port.`in`.command.WithdrawCommand
import com.example.estdelivery.application.port.out.LoadAccountPort
import com.example.estdelivery.application.port.out.UpdateAccountPort
import com.example.estdelivery.domain.AccountTransactions
import com.example.estdelivery.domain.Money
import com.example.estdelivery.moneyArbitraryBuilder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.LocalDateTime

class WithdrawServiceTest : FreeSpec({

    lateinit var loadAccountPort: LoadAccountPort
    lateinit var updateAccountPort: UpdateAccountPort
    lateinit var withdrawService: WithdrawService

    beforeTest {
        loadAccountPort = mockk<LoadAccountPort>()
        updateAccountPort = mockk<UpdateAccountPort>()
        withdrawService = WithdrawService(loadAccountPort, updateAccountPort)
    }

    "계좌에서 돈을 출금한다." {
        // given
        val accountNumber = accountNumberArbitraryBuilder().sample()
        val money = moneyArbitraryBuilder().sample()
        val account = accountArbitraryBuilder()
            .set("accountNumber", accountNumber)
            .set("transactions", AccountTransactions())
            .sample()
        account.deposit(money, LocalDateTime.now().minusDays(1))
        val withdrawCommand = WithdrawCommand(accountNumber, money, LocalDateTime.now())

        // when
        every { loadAccountPort.findByAccountNumber(withdrawCommand.accountNumber) } returns account
        every { updateAccountPort.update(account) } returns Unit

        withdrawService.withdraw(withdrawCommand)

        // then
        account.balance() shouldBe Money.ZERO
    }
})
