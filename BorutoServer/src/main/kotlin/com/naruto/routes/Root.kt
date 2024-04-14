package com.naruto.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.root() {
    get ("/"){
        call.respond(
            message = "Welcome to the Naruto API. You can find the list of heroes at /heroes",
            status = HttpStatusCode.OK
        )
    }
}
