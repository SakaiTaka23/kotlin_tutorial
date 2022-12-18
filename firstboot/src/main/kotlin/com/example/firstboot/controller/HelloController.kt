package com.example.firstboot.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Message(
    val message: String,
    val buildNumber: String
)

@RestController
class HelloController(
    @Value("\${example.firstboot.buildNumber}") val buildNumber: String
) {
    @GetMapping("/hello")
    fun hello(): Message {
        return Message("Hello", buildNumber)
    }
}
