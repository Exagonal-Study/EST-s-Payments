package com.example.estdelivery.adapter.out.persistence.user.adapter

import com.example.estdelivery.adapter.out.persistence.user.repository.UserRepository
import com.example.estdelivery.adapter.out.persistence.user.mapper.toEntity
import com.example.estdelivery.application.port.out.UserPersistencePort
import com.example.estdelivery.domain.User
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserPersistencePort {
    override fun save(user: User) {
        userRepository.save(user.toEntity())
    }
}