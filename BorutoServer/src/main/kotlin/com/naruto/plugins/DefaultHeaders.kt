package com.naruto.plugins

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import java.time.Duration

fun Application.configureDefaultHeaders() {
    val daysOfYear: Long = 365
    install(DefaultHeaders) {
        val oneYearInSeconds = Duration.ofDays(daysOfYear).seconds
        header(name = HttpHeaders.CacheControl, value = "max-age=$oneYearInSeconds")
    }
}
