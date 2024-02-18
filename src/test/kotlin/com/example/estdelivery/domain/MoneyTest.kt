package com.example.estdelivery.domain

import com.example.estdelivery.moneyArbitraryBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.FreeSpec
import net.jqwik.api.Arbitraries
import java.math.BigInteger

class MoneyTest : FreeSpec({
    "0이상의 숫자를 넣어" - {
        for (i in 0..300) {
            "$i 번째 금액을 생성한다." {
                val money = moneyArbitraryBuilder()
                shouldNotThrow<IllegalArgumentException> { money.sample() }
            }
        }
    }

    "금액은 0원 이상이어야 한다." - {
        val money = moneyArbitraryBuilder()
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
