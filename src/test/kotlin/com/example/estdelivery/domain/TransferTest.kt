package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import net.jqwik.api.Arbitraries
import java.math.BigInteger
import java.time.LocalDateTime

class TransferTest : FreeSpec({
    "이체하는데, " - {
        // given
        val source = fixtureMonkey.giveMeBuilder<Account>()
            .set("transactions", AccountTransactions(listOf()))
            .sample()
        val target = fixtureMonkey.giveMeBuilder<Account>()
            .set("transactions", AccountTransactions(listOf()))
            .sample()

        source.deposit(Money(6_000_000.toBigInteger()), LocalDateTime.now())
        var beforeSourceBalance = source.balance()
        var beforeTargetBalance = target.balance()
        for (i in 0..300) {
            "무려 $i 번째 이체이다." {
                val money = fixtureMonkey.giveMeBuilder<Money>()
                    .set("amount", Arbitraries.bigIntegers().between(BigInteger.ZERO, 20_000.toBigInteger()))
                    .sample()
                val transfer = Transfer(source, target, money, LocalDateTime.now())

                // when
                transfer.transfer()

                // then
                source.balance() shouldBe beforeSourceBalance - money
                target.balance() shouldBe beforeTargetBalance + money
                beforeSourceBalance = source.balance()
                beforeTargetBalance = target.balance()
            }
        }
    }
})
