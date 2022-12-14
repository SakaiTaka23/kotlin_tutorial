package com.kotlin.bank.controller.model

import java.util.Date

class OverviewTransactionModel (
    val targetAccount: String,
    val value: Double,
    val description: String,
    val date: Date,
    val id: String,
)
