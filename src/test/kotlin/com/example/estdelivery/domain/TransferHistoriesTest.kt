package com.example.estdelivery.domain

import com.example.estdelivery.transferHistoriesArbitraryBuilder
import com.example.estdelivery.transferHistoryArbitraryBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FreeSpec


class TransferHistoriesTest : FreeSpec({
    "이체 내역을 생성한다." {
        shouldNotThrow<IllegalArgumentException> {
            transferHistoriesArbitraryBuilder().sample()
        }
    }

    "이체 내역을 조회한다." {
        val histories = transferHistoriesArbitraryBuilder().sample()
        shouldNotThrow<IllegalArgumentException> {
            histories.showHistories()
        }
    }

    "이체 내역을 추가할 때" - {
        val histories = transferHistoriesArbitraryBuilder().sample()
        for (i in 0..100) {
            val transferHistory = transferHistoryArbitraryBuilder().sample()
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
})
