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
import io.kotest.matchers.shouldBe

class TransferHistoriesTest : FreeSpec({
    val fixtureMonkey = FixtureMonkey.builder()
        .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
        .plugin(KotlinPlugin())
        .plugin(JakartaValidationPlugin())
        .build()

    "이체 내역을 생성한다." {
        val list = fixtureMonkey.giveMeBuilder<List<TransferHistory>>().sample()

        shouldNotThrow<IllegalArgumentException> {
            TransferHistories(list)
        }
    }

    "이체 내역을 조회한다." {
        val histories = fixtureMonkey.giveMeBuilder<TransferHistories>().sample()
        shouldNotThrow<IllegalArgumentException> {
            histories.showHistories()
        }
    }

    "이체 내역을 추가할 때" - {
        val histories = fixtureMonkey.giveMeBuilder<TransferHistories>().sample()
        for (i in 0..100) {
            val transferHistory = fixtureMonkey.giveMeBuilder<TransferHistory>().sample()
            "$i 번째 이력을 추가한다." {
                shouldNotThrow<IllegalArgumentException> {
                    histories.addHistory(transferHistory)
                }
            }

            "$i 번째 이력을 제거한다." {
                shouldNotThrow<IllegalArgumentException> {
                    histories.removeHistory(transferHistory)
                }
            }
        }
    }

    "자신의 계좌를 확인할 때" - {
        "경계값 - 비어있어도 자신의 계좌이다." {
            val histories = TransferHistories(listOf())
            val number = fixtureMonkey.giveMeBuilder<AccountNumber>().sample()
            histories.ensureMyHistories(number) shouldBe true
        }

        "이력으로 자신의 계좌를 확인할 수 있다." {
            val sourceAccountNumber = fixtureMonkey.giveMeBuilder<AccountNumber>().sample()
            val histories = TransferHistories(listOf())
            for (i in 0..100) {
                val transferHistory = fixtureMonkey.giveMeBuilder<TransferHistory>()
                    .set("source", sourceAccountNumber)
                    .sample()
                histories.addHistory(transferHistory)
            }
            histories.ensureMyHistories(sourceAccountNumber) shouldBe true
        }
    }

})
