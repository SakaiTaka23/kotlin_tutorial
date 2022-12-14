package com.kotlin.bank.controller.repository.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.Date
import java.util.UUID

@Entity
class TransactionDBModel (
    val accountIdentifier: String,
    val value: Double,
    val description: String = "",
) {
    @Id
    @GeneratedValue
    var id: UUID? = null
        private set

    val date: Date = Date()
}
