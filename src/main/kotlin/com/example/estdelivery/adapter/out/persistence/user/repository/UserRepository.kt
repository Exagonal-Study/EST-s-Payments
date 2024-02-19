package com.example.estdelivery.adapter.out.persistence.user.repository

import com.example.estdelivery.adapter.out.persistence.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
}