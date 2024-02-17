package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class TransferHistoryTest : FreeSpec({
    "300번 중" - {
        for (i in 0..300) {
            "$i 번째 송금 내역을 생성한다." {
                println(fixtureMonkey.giveMeBuilder<TransferHistory>().sample())
            }
        }
    }

    "입금 계좌와 출금 계좌가 같을 수 없다." {
        val sameAccountNumber = fixtureMonkey.giveMeBuilder<AccountNumber>().sample()
        val money = fixtureMonkey.giveMeBuilder<Money>().sample()

        shouldThrow<IllegalArgumentException> {
            TransferHistory(sameAccountNumber, sameAccountNumber, money, LocalDateTime.now())
        }
    }

    "이체 일자는 현재 시간보다 이전이어야 한다." {
        val futureDateTime = LocalDateTime.now().plusDays(1)
        shouldThrow<IllegalArgumentException> {
            fixtureMonkey.giveMeBuilder<TransferHistory>()
                .set("transferDate", futureDateTime)
                .sample()
        }
    }
})
