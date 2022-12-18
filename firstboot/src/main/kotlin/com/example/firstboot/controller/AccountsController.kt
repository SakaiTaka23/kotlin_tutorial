package com.example.firstboot.controller

import com.example.firstboot.model.Account
import com.example.firstboot.model.AccountRepository
import com.example.firstboot.model.ViewAccount
import com.example.firstboot.model.toView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class CreateAccount(
    val name: String,
)

@RestController
@RequestMapping("/accounts")
class AccountsController(val repository: AccountRepository) {
    @GetMapping("")
    fun getAll(): Iterable<ViewAccount> {
        return listOf(ViewAccount(1, "alex"))
    }

    @GetMapping("/find")
    fun findAll(): Iterable<ViewAccount> {
        return repository.findAll().map { it.toView() }
    }

    @PostMapping("")
    fun create(@RequestBody request: CreateAccount): ViewAccount {
         return repository.save(
            Account(
                name = request.name
            )
        ).toView()
    }
}
