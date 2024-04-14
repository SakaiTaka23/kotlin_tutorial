package com.naruto.routes

import io.ktor.server.http.content.staticResources
import io.ktor.server.routing.Route

fun Route.statics() {
    staticResources("/images", basePackage = "images")
}
