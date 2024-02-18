package com.example.estdelivery.domain

import com.example.estdelivery.accountArbitraryBuilder
import com.example.estdelivery.accountNumberArbitraryBuilder
import com.example.estdelivery.transferHistoryArbitraryBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FreeSpec


class AccountTest : FreeSpec({
    fun transferHistories(myAccount: AccountNumber): TransferHistories {
        val 계좌_과거_이력 = TransferHistories(listOf())
        for (i in 0..10) {
            계좌_과거_이력.addHistory(
                transferHistoryArbitraryBuilder()
                    .set("source", myAccount)
                    .sample()
            )
            계좌_과거_이력.addHistory(
                transferHistoryArbitraryBuilder()
                    .set("target", myAccount)
                    .sample()
            )
        }
        return 계좌_과거_이력
    }

    "10번 계좌 생성 중" - {
        val 내_계좌 = accountNumberArbitraryBuilder().sample()
        val 계좌_과거_이력 = transferHistories(내_계좌)
        for (i in 0..10) {
            "$i 번째 계좌를 생성한다." {
                shouldNotThrowAny {
                    accountArbitraryBuilder()
                        .set("number", 내_계좌)
                        .set("transferHistories", 계좌_과거_이력)
                }
            }
        }
    }
})
