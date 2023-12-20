package com.ray.guess.domain.repository.guess.city

import com.ray.guess.domain.model.guess.city.City

interface CityRepository {

    suspend fun getCityById(id: Long): City?

    suspend fun getCityList(): List<City>

    suspend fun getRandomCity(): City?
}
