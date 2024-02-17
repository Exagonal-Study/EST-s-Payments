package com.example.estdelivery.domain

class TransferHistories(
    private var transferHistories: List<TransferHistory>
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

    fun ensureMyHistories(number: AccountNumber): Boolean {
        for (transferHistory in transferHistories) {
            if (transferHistory.isMyHistory(number).not()) {
                return false
            }
        }
        return true
    }

    override fun toString(): String {
        return "TransferHistories(transferHistories=$transferHistories)"
    }
}
