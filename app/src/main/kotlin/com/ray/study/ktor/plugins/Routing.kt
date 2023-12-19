package com.ray.study.ktor.plugins

import com.ray.study.ktor.di.DaggerServiceFactory
import com.ray.study.ktor.presentation.student.studentRouting
import io.ktor.server.application.Application
import io.ktor.server.routing.routing


fun Application.configureRouting() {
    routing {
        val factory = DaggerServiceFactory.create()
        studentRouting(service = factory.studentService())
    }
}
