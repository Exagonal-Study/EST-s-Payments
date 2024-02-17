package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class AccountNumberTest : FreeSpec({

    "임의 번호를 생성해" - {
        val fixtureMonkey = FixtureMonkey.builder()
            .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
            .plugin(KotlinPlugin())
            .plugin(JakartaValidationPlugin())
            .build()

        for (i in 0..300) {
            "$i 번째 계좌 번호를 생성한다." {
                shouldNotThrow<IllegalArgumentException> {
                    fixtureMonkey.giveMeBuilder<AccountNumber>().sample()
                }
            }
        }
    }

    "계좌번호는 10자리가 아니면 예외가 발생한다." {
        val accountNumber = "123456789"
        val exception = shouldThrow<IllegalArgumentException> {
            AccountNumber(accountNumber)
        }
        exception.message shouldBe "계좌번호는 10자리여야 합니다."
    }
})
