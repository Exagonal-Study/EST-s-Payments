package com.example.estdelivery.domain

import com.example.estdelivery.accountArbitraryBuilder
import com.example.estdelivery.moneyArbitraryBuilder
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import net.jqwik.api.Arbitraries
import java.math.BigInteger
import java.time.LocalDateTime

class WithdrawalTest : FreeSpec({

    "출금하는데, " - {
        // given
        val account = accountArbitraryBuilder()
            .set("transactions", AccountTransactions(listOf()))
            .sample()
        account.deposit(Money(6_000_000.toBigInteger()), LocalDateTime.now())

        var beforeBalance = account.balance()
        for (i in 0..300) {
            "무려 $i 번째 출금이다." {
                val money = moneyArbitraryBuilder()
                    .set("amount", Arbitraries.bigIntegers().between(BigInteger.ZERO, 20_000.toBigInteger()))
                    .sample()
                val withdrawal = Withdrawal(account, money, LocalDateTime.now())

                // when
                withdrawal.withdraw()

                // then
                account.balance() shouldBe beforeBalance - money
                beforeBalance = account.balance()
            }
        }
    }

    "출금하는데 잔액이 부족하면 예외가 발생한다." {
        val account = accountArbitraryBuilder()
            .set("transactions", AccountTransactions(listOf()))
            .sample()
        val money = moneyArbitraryBuilder().sample()

        shouldThrow<IllegalArgumentException> {
            Withdrawal(account, money, LocalDateTime.now())
        }
    }

})
