package com.example.firstboot.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
)

fun Account.toView() = ViewAccount(id, name)

data class ViewAccount(
    val id: Long,
    val name: String,
)

interface AccountRepository: CrudRepository<Account, Long> {
    fun findByNameStartingWith(prefix: String): Iterable<Account>

    @Query("SELECT a FROM Account a WHERE a.name LIKE concat('%', :suffix)")
    fun search(suffix: String): Iterable<Account>
}
