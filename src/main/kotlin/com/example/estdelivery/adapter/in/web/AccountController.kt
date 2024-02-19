package com.example.estdelivery.adapter.`in`.web

import com.example.estdelivery.adapter.`in`.web.dto.account.request.RegisterAccountRequest
import com.example.estdelivery.adapter.`in`.web.dto.account.response.AccountSummaryResponse
import com.example.estdelivery.application.port.`in`.RegisterAccountUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
    private val registerAccountUseCase: RegisterAccountUseCase
) {

    @GetMapping
    fun getAccounts(@RequestParam userId: Long): List<AccountSummaryResponse> {
        TODO()
    }

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: Long): AccountSummaryResponse {
        TODO()
    }

    @PostMapping
    fun registerAccount(@RequestBody request: RegisterAccountRequest) {
        registerAccountUseCase.registerAccount(request.userId)
    }
}