package com.ray.guess.presentation.guess

import com.ray.guess.presentation.guess.city.CityService
import com.ray.guess.presentation.guess.city.cityRouting
import io.ktor.server.routing.Route
import io.ktor.server.routing.route

fun Route.guessRouting(
    service: CityService
) {
    route("/guess") {
        cityRouting(service)
    }
}
