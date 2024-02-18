package com.example.estpayments.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
}
