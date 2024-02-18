package com.example.estpayments.adapter.`in`.web

import com.example.estpayments.adapter.`in`.web.dto.TransactionExecuteRequest
import com.example.estpayments.adapter.`in`.web.dto.TransactionExecuteResponse
import com.example.estpayments.application.port.`in`.TransactionExecuteUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(
    private val transactionExecuteUseCase: TransactionExecuteUseCase
) {
    @PostMapping
    fun executeTransaction(
        @RequestBody transactionExecuteRequest: TransactionExecuteRequest
    ): Result<TransactionExecuteResponse> =
        Result.success(
            TransactionExecuteResponse.from(
                transactionExecuteUseCase.execute(transactionExecuteRequest.toCommand())
            )
        )
}