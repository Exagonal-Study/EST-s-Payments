package com.example.estdelivery.adapter.out.persistence.user.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "user")
class UserEntity(
    name: String
//    balance: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    var name: String? = name
        protected set

//    var balance: BigDecimal = balance
//        protected set
}