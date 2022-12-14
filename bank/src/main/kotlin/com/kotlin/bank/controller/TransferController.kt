package com.kotlin.bank.controller

import com.kotlin.bank.controller.model.OverviewTransactionModel
import com.kotlin.bank.controller.model.TransactionModel
import com.kotlin.bank.controller.model.convertToDBModel
import com.kotlin.bank.controller.model.convertToOverviewTransactionModel
import com.kotlin.bank.repository.TransferRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transfer")
class TransferController(val repository: TransferRepository) {

    @PostMapping("/new")
    fun newTransfer(@RequestBody transactionModel: TransactionModel) {
        repository.save(transactionModel.convertToDBModel())
    }

    @GetMapping("/all")
    fun getAllTransfers(): List<OverviewTransactionModel> {
        return repository.findAll().map { it.convertToOverviewTransactionModel() }
    }
}
