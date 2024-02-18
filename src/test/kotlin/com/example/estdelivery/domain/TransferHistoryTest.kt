package com.example.estdelivery.domain

import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.moneyArbitraryBuilder
import com.example.estdelivery.transferHistoryArbitraryBuilder
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import java.time.LocalDateTime

class TransferHistoryTest : FreeSpec({
    "300번 중" - {
        for (i in 0..300) {
            "$i 번째 송금 내역을 생성한다." {
                println(transferHistoryArbitraryBuilder().sample())
            }
        }
    }

    "입금 계좌와 출금 계좌가 같을 수 없다." {
        val sameAccountNumber = accountNumberArbitraryBuilder().sample()
        val money = moneyArbitraryBuilder().sample()

        shouldThrow<IllegalArgumentException> {
            TransferHistory(sameAccountNumber, sameAccountNumber, money, LocalDateTime.now())
        }
    }

    "이체 일자는 현재 시간보다 이전이어야 한다." {
        val futureDateTime = LocalDateTime.now().plusDays(1)
        shouldThrow<IllegalArgumentException> {
            transferHistoryArbitraryBuilder()
                .set("transferDate", futureDateTime)
                .sample()
        }
    }
})
