package com.example.estdelivery

import com.example.estdelivery.application.port.`in`.command.CreateAccountCommand
import com.example.estdelivery.domain.Account
import com.example.estdelivery.domain.AccountNumber
import com.example.estdelivery.domain.AccountTransaction
import com.example.estdelivery.domain.AccountTransactions
import com.example.estdelivery.domain.Money
import com.example.estdelivery.domain.TransferHistories
import com.example.estdelivery.domain.TransferHistory
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder

private val fixtureMonkey: FixtureMonkey = FixtureMonkey.builder()
    .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
    .plugin(KotlinPlugin())
    .plugin(JakartaValidationPlugin())
    .build()

fun accountCommandArbitraryBuilder() = fixtureMonkey.giveMeBuilder<CreateAccountCommand>()
fun moneyArbitraryBuilder() = fixtureMonkey.giveMeBuilder<Money>()
fun accountArbitraryBuilder() = fixtureMonkey.giveMeBuilder<Account>()
fun accountNumberArbitraryBuilder() = fixtureMonkey.giveMeBuilder<AccountNumber>()
fun transferHistoryArbitraryBuilder() = fixtureMonkey.giveMeBuilder<TransferHistory>()
fun transferHistoriesArbitraryBuilder() = fixtureMonkey.giveMeBuilder<TransferHistories>()
fun accountTransactionArbitraryBuilder() = fixtureMonkey.giveMeBuilder<AccountTransaction>()
fun accountTransactionsArbitraryBuilder() = fixtureMonkey.giveMeBuilder<AccountTransactions>()
