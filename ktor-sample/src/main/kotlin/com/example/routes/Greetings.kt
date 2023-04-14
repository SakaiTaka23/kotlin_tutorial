package com.example.routes

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Routing.greetingRoute() {
    route("greeting") {
        get("/hello") {
            call.respondText("Hello!")
        }

        get("/goodmorning") {
            call.respondText("Good Morning")
        }
    }
}
