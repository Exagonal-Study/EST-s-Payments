package com.example.estdelivery.application.port.out.persistence.infra

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class AccountNumberSequence {
    /**
     * 숫자 10 자리를 포함한 문자를 반환한다.
     */
    fun next(): String {
        val random = Random(System.currentTimeMillis())
        val sb = StringBuilder(10)
        for (i in 0 until 10) {
            sb.append(random.nextInt(10))
        }
        return sb.toString()
    }
}
