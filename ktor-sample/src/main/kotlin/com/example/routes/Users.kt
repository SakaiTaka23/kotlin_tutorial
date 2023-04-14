package com.example.routes

import io.ktor.server.application.call
import io.ktor.server.locations.KtorExperimentalLocationsAPI
import io.ktor.server.locations.Location
import io.ktor.server.locations.get
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/user/{id}")
data class GetUserLocation(val id: Long)

@OptIn(KtorExperimentalLocationsAPI::class)
fun Routing.userRoute() {
    get<GetUserLocation> { param ->
        val id = param.id
        call.respondText("id=$id")
    }
}
