package com.example.estdelivery.adapter.out.persistence.user.mapper

import com.example.estdelivery.adapter.out.persistence.user.entity.UserEntity
import com.example.estdelivery.domain.User

fun User.toEntity(): UserEntity {
    return UserEntity(
        name = this.name
//        balance = this.balance
    )
}

fun UserEntity.toDomain(): User {
    return User(
        id = this.id!!,
        name = this.name!!,
//        balance = this.balance
    )
}