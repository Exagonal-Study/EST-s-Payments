package com.example.estpayments.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, Long> {
}
