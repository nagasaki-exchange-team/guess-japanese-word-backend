package com.ray.guess.domain.usecase.guess.city

import com.ray.guess.domain.model.guess.city.City
import com.ray.guess.domain.repository.guess.city.CityRepository
import javax.inject.Inject

class GetRandomCityUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(): City? {
        return cityRepository.getRandomCity()
    }
}
