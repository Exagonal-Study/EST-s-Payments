package com.example.estpayments.config

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.util.Locale

@Component
class ImprovedNamingStrategy : PhysicalNamingStrategy {
    override fun toPhysicalCatalogName(
        name: Identifier?,
        jdbcEnvironment: JdbcEnvironment?,
    ): Identifier? {
        return convert(name)
    }

    override fun toPhysicalSchemaName(
        name: Identifier?,
        jdbcEnvironment: JdbcEnvironment?,
    ): Identifier? {
        return convert(name)
    }

    override fun toPhysicalTableName(
        name: Identifier?,
        jdbcEnvironment: JdbcEnvironment?,
    ): Identifier? {
        return convert(name)
    }

    override fun toPhysicalSequenceName(
        name: Identifier?,
        jdbcEnvironment: JdbcEnvironment?,
    ): Identifier? {
        return convert(name)
    }

    override fun toPhysicalColumnName(
        name: Identifier?,
        jdbcEnvironment: JdbcEnvironment?,
    ): Identifier? {
        return convert(name)
    }

    private fun convert(identifier: Identifier?): Identifier? {
        if (identifier == null || !StringUtils.hasText(identifier.text)) {
            return identifier
        }

        val regex = "([a-z])([A-Z])"
        val replacement = "$1_$2"
        val newName = identifier.text.replace(regex.toRegex(), replacement).lowercase(Locale.getDefault())
        return Identifier.toIdentifier(newName)
    }
}
