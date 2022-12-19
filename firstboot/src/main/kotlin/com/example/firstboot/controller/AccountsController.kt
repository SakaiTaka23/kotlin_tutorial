package com.example.firstboot.controller

import com.example.firstboot.model.Account
import com.example.firstboot.model.AccountRepository
import com.example.firstboot.model.ViewAccount
import com.example.firstboot.model.toView
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class CreateAccount(
    @field:Size(min = 2, max = 5)
    val name: String,
)

@RestController
@RequestMapping("/accounts")
class AccountsController(val repository: AccountRepository) {
    @GetMapping
    fun getAll(): Iterable<ViewAccount> {
        return listOf(ViewAccount(1, "alex"))
    }

    @GetMapping("/find")
    fun findAll(): Iterable<ViewAccount> {
        return repository.findAll().map { it.toView() }
    }

    @GetMapping("/start")
    fun searchStart(@RequestParam(name = "prefix") prefix: String): Iterable<ViewAccount> {
        return repository.findByNameStartingWith(prefix).map { it.toView() }
    }

    @GetMapping("/end")
    fun searchEnd(@RequestParam(name = "sufix") sufix: String): Iterable<ViewAccount> {
        return repository.search(sufix).map { it.toView() }
    }

    @PostMapping
    fun create(@RequestBody request: CreateAccount): ViewAccount {
         return repository.save(
            Account(
                name = request.name
            )
        ).toView()
    }

    @PostMapping("/valid")
    fun valid(@Valid @RequestBody request: CreateAccount): ViewAccount {
        return ViewAccount(id = 2, name = request.name)
    }
}
