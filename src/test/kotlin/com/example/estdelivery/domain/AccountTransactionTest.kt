package com.example.estdelivery.domain

import com.example.estdelivery.accountTransactionArbitraryBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FreeSpec
import java.time.LocalDateTime

class AccountTransactionTest : FreeSpec({
    "계좌 거래 내역을 생성한다." - {
        for (i in 0..300) {
            "$i 번째 거래 내역을 생성한다." {
                shouldNotThrow<IllegalArgumentException> {
                    accountTransactionArbitraryBuilder()
                        .sample()
                }
            }
        }
    }

    "계좌 거래 일자가 미래일 수 없다." {
        val futureDate = LocalDateTime.now().plusDays(1)
        shouldNotThrow<IllegalArgumentException> {
            accountTransactionArbitraryBuilder()
                .set("transactionTime", futureDate)
                .sample()
        }
    }
})
