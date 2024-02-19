package com.example.estdelivery.adapter.out.persistence.transaction.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "transaction")
class TransactionEntity(
    accountId: String,
    amount: BigDecimal
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    var accountId: String? = accountId
        protected set

    var amount: BigDecimal = amount
        protected set
}