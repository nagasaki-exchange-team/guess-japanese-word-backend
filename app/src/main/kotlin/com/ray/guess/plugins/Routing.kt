package com.ray.guess.plugins

import com.ray.guess.di.DaggerServiceFactory
import com.ray.guess.presentation.student.studentRouting
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        val factory = DaggerServiceFactory.create()
        studentRouting(service = factory.studentService())
    }
}
