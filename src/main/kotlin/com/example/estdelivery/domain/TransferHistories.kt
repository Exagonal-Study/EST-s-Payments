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
}
