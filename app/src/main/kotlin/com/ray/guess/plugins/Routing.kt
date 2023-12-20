package com.ray.guess.plugins

import com.ray.guess.di.DaggerServiceFactory
import com.ray.guess.presentation.guess.guessRouting
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        val factory = DaggerServiceFactory.create()
        guessRouting(service = factory.cityService())
    }
}
