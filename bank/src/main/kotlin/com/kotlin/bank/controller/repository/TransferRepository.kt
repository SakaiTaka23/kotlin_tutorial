package com.kotlin.bank.controller.repository

import com.kotlin.bank.controller.repository.model.TransactionDBModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TransferRepository: CrudRepository<TransactionDBModel, UUID> {
}
