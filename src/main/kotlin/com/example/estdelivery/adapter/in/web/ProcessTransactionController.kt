package com.example.estdelivery.adapter.`in`.web

import com.example.estdelivery.adapter.`in`.web.dto.transaction.request.RemitRequest
import com.example.estdelivery.application.port.`in`.ProcessTransactionUseCase
import com.example.estdelivery.application.service.ProcessTransactionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class ProcessTransactionController(
    private val processTransactionUseCase: ProcessTransactionUseCase
) {

    @PostMapping
    fun processTransaction(@RequestBody request: RemitRequest) {
        processTransactionUseCase.process(
            request.senderId,
            request.senderAccountId,
            request.receiverId,
            request.receiverAccountId,
            request.amount
        )
    }
}