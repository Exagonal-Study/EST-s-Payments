package com.example.estdelivery.application.port.out

import com.example.estdelivery.domain.User

interface UserPersistencePort {
    fun save(user: User)
}