package com.naruto

import com.naruto.plugins.configureDefaultHeaders
import com.naruto.plugins.configureKoin
import com.naruto.plugins.configureMonitoring
import com.naruto.plugins.configureRouting
import com.naruto.plugins.configureSerialization
import com.naruto.plugins.configureStatusPages
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureDefaultHeaders()
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureStatusPages()
}
