package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FreeSpec
import java.time.LocalDateTime

class AccountTransactionsTest : FreeSpec({
    val accountTransactions = fixtureMonkey.giveMeBuilder<AccountTransactions>().sample()
    val money = fixtureMonkey.giveMeBuilder<Money>().sample()

    "돈 입금 기록을 추가한다." {
        shouldNotThrow<IllegalArgumentException> {
            accountTransactions.deposit(money, LocalDateTime.now())
        }
    }

    "돈 출금 기록을 추가한다." {
        shouldNotThrow<IllegalArgumentException> {
            accountTransactions.withdraw(money, LocalDateTime.now())
        }
    }

    "잔액을 조회한다." {
        println(accountTransactions.balance())
    }
})
