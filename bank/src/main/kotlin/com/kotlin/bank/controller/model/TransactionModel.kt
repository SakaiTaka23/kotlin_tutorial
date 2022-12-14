package com.kotlin.bank.controller.model

import com.kotlin.bank.repository.model.TransactionDBModel

class TransactionModel(
    val targetAccount: String,
    val value: Double,
    val description: String = "",
)

fun TransactionModel.convertToDBModel() = TransactionDBModel(
    accountIdentifier = this.targetAccount,
    amount = this.value,
    description = this.description
)
