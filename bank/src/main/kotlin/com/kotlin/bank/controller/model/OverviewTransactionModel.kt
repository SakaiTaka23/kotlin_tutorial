package com.kotlin.bank.controller.model

import com.kotlin.bank.repository.model.TransactionDBModel
import java.util.Date

class OverviewTransactionModel (
    val targetAccount: String,
    val value: Double,
    val description: String,
    val date: Date,
    val id: String,
)

fun TransactionDBModel.convertToOverviewTransactionModel() = OverviewTransactionModel(
    targetAccount = this.accountIdentifier,
    value = this.amount,
    description = this.description,
    date = this.date,
    id = this.id.toString()
)
