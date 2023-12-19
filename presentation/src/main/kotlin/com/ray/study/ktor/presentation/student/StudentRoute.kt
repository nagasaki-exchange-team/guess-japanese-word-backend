package com.ray.study.ktor.presentation.student

import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.studentRouting(
    service: StudentService
) {
    route("/student") {
        get("{id?}") {
            service.onGetStudentCall(this)
        }
    }
}
