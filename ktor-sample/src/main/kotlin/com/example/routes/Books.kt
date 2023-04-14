package com.example.routes

import io.ktor.server.application.call
import io.ktor.server.locations.KtorExperimentalLocationsAPI
import io.ktor.server.locations.Location
import io.ktor.server.locations.get
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.post
import io.ktor.server.routing.route

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/detail/{bookId}")
data class BookLocation(val bookId: Long)

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String,
)

@OptIn(KtorExperimentalLocationsAPI::class)
fun Routing.bookRoute() {
    route("/book"){
        get<BookLocation> { request ->
            val response = BookResponse(request.bookId, "Kotlin入門", "Kotlin太郎")
            call.respond(response)
        }

        post {
            val request = call.receive<BookResponse>()
            call.respondText("request body: $request")
        }
    }
}
