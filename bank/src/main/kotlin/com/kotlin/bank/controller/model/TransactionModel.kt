package com.kotlin.bank.controller.model

class TransactionModel(
    val targetAccount: String,
    val value: Double,
    val description: String = "",
)
