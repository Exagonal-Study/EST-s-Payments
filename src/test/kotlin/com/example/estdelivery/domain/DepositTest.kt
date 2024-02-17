package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class DepositTest : FreeSpec({
    "입금하는데, " - {
        for (i in 0..300) {
            // given
            val account = fixtureMonkey.giveMeBuilder<Account>()
                .set("transactions", AccountTransactions(listOf()))
                .sample()
            var beforeBalance = account.balance()
            "무려 $i 번째 입금이다." {
                val money = fixtureMonkey.giveMeBuilder<Money>().sample()
                val deposit = Deposit(account, money, LocalDateTime.now())

                // when
                deposit.deposit()

                // then
                account.balance() shouldBe beforeBalance + money
                beforeBalance = account.balance()
            }
        }
    }
})
