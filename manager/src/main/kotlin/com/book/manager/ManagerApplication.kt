package com.book.manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ManagerApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ManagerApplication>(*args)
}
