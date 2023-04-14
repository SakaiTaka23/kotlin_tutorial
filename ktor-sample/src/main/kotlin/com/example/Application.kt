package com.example

import com.example.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.locations.KtorExperimentalLocationsAPI
import io.ktor.server.netty.Netty
import io.ktor.server.locations.Locations

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.module() {
    install(Locations)
    configureRouting()
}
