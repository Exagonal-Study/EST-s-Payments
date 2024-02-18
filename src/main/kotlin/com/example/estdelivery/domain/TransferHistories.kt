package com.example.estdelivery.domain

class TransferHistories(
    private var transferHistories: List<TransferHistory> = listOf()
) {
    fun showHistories(): List<TransferHistory> {
        return transferHistories
    }

    fun addHistory(transferHistory: TransferHistory) {
        transferHistories = transferHistories + transferHistory
    }

    fun removeHistory(transferHistory: TransferHistory) {
        transferHistories = transferHistories - transferHistory
    }

    override fun toString(): String {
        return "TransferHistories(transferHistories=$transferHistories)"
    }
}
