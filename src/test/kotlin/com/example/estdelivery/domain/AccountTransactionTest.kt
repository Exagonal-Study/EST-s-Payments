package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FreeSpec
import java.time.LocalDateTime

class AccountTransactionTest : FreeSpec({
    "계좌 거래 내역을 생성한다." - {
        for (i in 0..300) {
            "$i 번째 거래 내역을 생성한다." {
                shouldNotThrow<IllegalArgumentException> {
                    fixtureMonkey.giveMeBuilder<AccountTransaction>()
                        .sample()
                }
            }
        }
    }

    "계좌 거래 일자가 미래일 수 없다." {
        val futureDate = LocalDateTime.now().plusDays(1)
        shouldNotThrow<IllegalArgumentException> {
            fixtureMonkey.giveMeBuilder<AccountTransaction>()
                .set("transactionTime", futureDate)
                .sample()
        }
    }
})
