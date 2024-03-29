package com.example.plugins

import com.example.routes.bookRoute
import com.example.routes.greetingRoute
import com.example.routes.userRoute
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.UserIdPrincipal
import io.ktor.server.auth.authenticate
import io.ktor.server.auth.authentication
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/hello/{name}") {
            val name = call.parameters["name"]
            call.respondText("Hello $name!")
        }
        get("/hello") {
            val name = call.request.queryParameters["name"]
            call.respondText("Hello $name!")
        }
        authenticate {
            get("/authenticated") {
                val user = call.authentication.principal<UserIdPrincipal>()
                call.respondText("authenticated id=${user?.name}")
            }
        }
        greetingRoute()
        userRoute()
        bookRoute()
    }
}
