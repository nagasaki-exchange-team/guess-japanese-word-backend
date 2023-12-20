package com.ray.guess.presentation.guess.city

import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.cityRouting(
    service: CityService
) {
    route("/city") {
        get("random") {
            service.onGetRandomCityCall(this)
        }
        get("all") {
            service.onGetCityListCall(this)
        }
        get("{id?}") {
            service.onGetCityCall(this)
        }
    }
}
