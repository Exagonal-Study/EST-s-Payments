package com.example.estpayments.adapter.`in`.web

import com.example.estpayments.adapter.`in`.web.dto.AccountCreateRequest
import com.example.estpayments.adapter.`in`.web.dto.AccountCreateResponse
import com.example.estpayments.adapter.`in`.web.dto.AccountResponse
import com.example.estpayments.application.domain.model.AccountId
import com.example.estpayments.application.port.`in`.AccountCreateUseCase
import com.example.estpayments.application.port.`in`.AccountFindUseCase
import com.example.estpayments.application.port.`in`.command.AccountFindCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
    private val accountCreateUseCase: AccountCreateUseCase,
    private val accountFindUseCase: AccountFindUseCase
) {
    @PostMapping
    fun createAccount(
        @RequestBody accountCreateRequest: AccountCreateRequest
    ): Result<AccountCreateResponse> =
        Result.success(
            AccountCreateResponse.from(
                accountCreateUseCase.create(accountCreateRequest.toCommand())
            )
        )

    @GetMapping("/{id}")
    fun getAccount(
        @PathVariable id: Long
    ): Result<AccountResponse> =
        Result.success(
            AccountResponse.from(
                accountFindUseCase.get(AccountFindCommand(AccountId(id)))
            )
        )
}