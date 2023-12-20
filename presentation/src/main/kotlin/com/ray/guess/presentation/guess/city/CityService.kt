package com.ray.guess.presentation.guess.city

import com.ray.guess.domain.usecase.guess.city.GetRandomCityUseCase
import com.ray.guess.domain.usecase.guess.city.GetCityByIdUseCase
import com.ray.guess.domain.usecase.guess.city.GetCityListUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.util.pipeline.PipelineContext
import javax.inject.Inject

class CityService @Inject constructor(
    private val getCityByIdUseCase: GetCityByIdUseCase,
    private val getRandomCityUseCase: GetRandomCityUseCase,
    private val getCityListUseCase: GetCityListUseCase
) {

    suspend fun onGetCityCall(context: PipelineContext<Unit, ApplicationCall>) = with(context) {
        val id = call.parameters["id"] ?: return call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        val city = id.toLongOrNull()?.let {
            getCityByIdUseCase(id = it)
        } ?: return call.respondText(
            "No city with id $id",
            status = HttpStatusCode.NotFound
        )

        call.respond(city)
    }

    suspend fun onGetRandomCityCall(context: PipelineContext<Unit, ApplicationCall>) = with(context) {
        val city = getRandomCityUseCase() ?: return call.respondText(
            "There is no city data",
            status = HttpStatusCode.InternalServerError
        )

        call.respond(city)
    }

    suspend fun onGetCityListCall(context: PipelineContext<Unit, ApplicationCall>) = with(context) {
        val cities = getCityListUseCase()

        call.respond(cities)
    }
}
