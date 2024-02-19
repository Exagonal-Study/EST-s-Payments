package com.example.estdelivery.application.service

import com.example.estdelivery.application.port.`in`.RegisterUserUseCase
import com.example.estdelivery.application.port.out.UserPersistencePort
import com.example.estdelivery.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class RegisterUserService(
    private val userPersistencePort: UserPersistencePort
) : RegisterUserUseCase {

    @Transactional
    override fun registerUser(name: String) {
        val user = User(name)
        userPersistencePort.save(user)
    }
}