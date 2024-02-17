package com.example.estdelivery.domain

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import net.jqwik.api.Arbitraries
import java.math.BigInteger

class MoneyTest : FreeSpec({
    val fixtureMonkey = FixtureMonkey.builder()
        .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
        .plugin(KotlinPlugin())
        .plugin(JakartaValidationPlugin())
        .build()

    "0이상의 숫자를 넣어" - {
        for (i in 0..300) {
            "$i 번째 금액을 생성한다." {
                val money = fixtureMonkey.giveMeBuilder<Money>()
                shouldNotThrow<IllegalArgumentException> { money.sample() }
            }
        }
    }

    "금액은 0원 이상이어야 한다." - {
        val money = fixtureMonkey.giveMeBuilder<Money>()
            .set("amount", Arbitraries.bigIntegers().lessOrEqual(BigInteger.valueOf(-1L)))

        for (i in 0..200) {
            "$i 번째 금액을 생성한다." {
                shouldThrowAny {
                    money.sample()
                }
            }
        }
    }
})
