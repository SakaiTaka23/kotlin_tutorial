package com.example.firstboot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class ViewAccount(
    val id: Int,
    val name: String,
)

data class CreateAccount(
    val name: String,
)

@RestController
@RequestMapping("/accounts")
class AccountsController {
    @GetMapping("")
    fun getAll(): Iterable<ViewAccount> {
        return listOf(ViewAccount(1, "alex"))
    }

    @PostMapping("")
    fun create(@RequestBody request: CreateAccount): ViewAccount {
        val random = (1..20).random()
        return ViewAccount(random, "dmaid")
    }
}
