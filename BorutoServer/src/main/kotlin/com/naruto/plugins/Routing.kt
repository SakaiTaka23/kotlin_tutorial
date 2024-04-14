package com.naruto.plugins

import com.naruto.routes.getAllHeroes
import com.naruto.routes.root
import com.naruto.routes.searchHeroes
import com.naruto.routes.statics
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        root()
        statics()
        getAllHeroes()
        searchHeroes()
    }
}
