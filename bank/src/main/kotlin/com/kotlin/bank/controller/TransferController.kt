package com.kotlin.bank.controller

import com.kotlin.bank.controller.model.OverviewTransactionModel
import com.kotlin.bank.controller.model.TransactionModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transfer")
class TransferController {

    @PostMapping("/new")
    fun newTransfer(@RequestBody transactionModel: TransactionModel) {
        // TODO: save the data
        println("Saved")
    }

    @GetMapping("/all")
    fun getAllTransfers(): List<OverviewTransactionModel> {
        // TODO: fetch the data
        return listOf()
    }
}
