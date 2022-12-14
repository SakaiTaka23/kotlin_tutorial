package com.kotlin.bank.repository

import com.kotlin.bank.repository.model.TransactionDBModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TransferRepository: CrudRepository<TransactionDBModel, UUID>
