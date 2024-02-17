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
import java.math.BigInteger

class MoneyTest : FreeSpec({
    "0이상의 숫자를 넣어" - {
        val fixtureMonkey = FixtureMonkey.builder()
            .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
            .plugin(KotlinPlugin())
            .plugin(JakartaValidationPlugin())
            .build()

        for (i in 0..300) {
            "$i 번째 금액을 생성한다." {
                val giveMeBuilder = fixtureMonkey.giveMeBuilder<Money>()
                shouldNotThrow<IllegalArgumentException> { giveMeBuilder.sample() }
            }
        }
    }

    "금액은 0원 이상이어야 한다." {
        shouldThrow<IllegalArgumentException> {
            Money(BigInteger.valueOf(-1))
        }.message shouldBe "금액은 0원 이상이어야 합니다."
    }
})
