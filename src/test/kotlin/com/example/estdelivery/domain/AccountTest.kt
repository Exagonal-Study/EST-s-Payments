package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.api.matcher.MatcherOperator
import com.navercorp.fixturemonkey.api.property.PropertyNameResolver
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FreeSpec
import java.time.LocalDateTime

class AccountTest : FreeSpec({
    fun transferHistories(myAccount: AccountNumber): TransferHistories {
        val 계좌_과거_이력 = TransferHistories(listOf())
        for (i in 0..10) {
            계좌_과거_이력.addHistory(
                fixtureMonkey.giveMeBuilder<TransferHistory>()
                    .set("source", myAccount)
                    .sample()
            )
            계좌_과거_이력.addHistory(
                fixtureMonkey.giveMeBuilder<TransferHistory>()
                    .set("target", myAccount)
                    .sample()
            )
        }
        return 계좌_과거_이력
    }

    "10번 계좌 생성 중" - {
        val 내_계좌 = fixtureMonkey.giveMeBuilder<AccountNumber>().sample()
        val 계좌_과거_이력 = transferHistories(내_계좌)
        for (i in 0..10) {
            "$i 번째 계좌를 생성한다." {
                shouldNotThrow<IllegalArgumentException> {
                    fixtureMonkey.giveMeBuilder<Account>()
                        .set("number", 내_계좌)
                        .set("transferHistories", 계좌_과거_이력)
                }
            }
        }
    }
})
