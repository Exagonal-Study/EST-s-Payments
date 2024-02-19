package com.example.estdelivery.adapter.`in`.web

import com.example.estdelivery.adapter.`in`.web.dto.user.request.RegisterUserRequest
import com.example.estdelivery.application.port.`in`.RegisterUserUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class RegisterUserController(
    private val registerUserUseCase: RegisterUserUseCase
) {
    @PostMapping
    fun registerUser(@RequestBody request: RegisterUserRequest) {
        registerUserUseCase.registerUser(request.name)
    }
}