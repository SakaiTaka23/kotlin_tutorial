package com.naruto

import com.naruto.models.ApiResponse
import com.naruto.plugins.configureKoin
import com.naruto.plugins.configureRouting
import com.naruto.plugins.configureSerialization
import com.naruto.repository.HeroRepositoryImpl
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    private val heroRepository = HeroRepositoryImpl()

    @Test
    fun testRootRoute() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Welcome to the Naruto API. You can find the list of heroes at /heroes", bodyAsText())
        }
    }

    @Test
    fun testAllHeroesRoute() = testApplication {
        application {
            configureKoin()
            configureSerialization()
            configureRouting()
        }
        client.get("/boruto/heroes").apply {
            assertEquals(HttpStatusCode.OK, status)
            val expectedResponse = ApiResponse(
                success = true,
                message = "Heroes Retrieved Successfully",
                prevPage = null,
                nextPage = 2,
                heroes = heroRepository.page1,
            )
            val actualResponse = Json.decodeFromString<ApiResponse>(bodyAsText())
            assertEquals(expectedResponse, actualResponse)
        }
    }
}
