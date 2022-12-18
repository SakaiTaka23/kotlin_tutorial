package com.example.firstboot.controller

import org.slf4j.LoggerFactory
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
    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/hello")
    fun hello(): Message {
        logger.trace("trace")
        logger.debug("debug")

        logger.info("info")
        logger.warn("warn")
        logger.error("error")

        return Message("Hello", buildNumber)
    }
}
