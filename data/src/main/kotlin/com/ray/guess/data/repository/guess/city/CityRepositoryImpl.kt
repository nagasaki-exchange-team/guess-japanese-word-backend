package com.ray.guess.data.repository.guess.city

import com.ray.guess.data.source.local.guess.city.CityDao
import com.ray.guess.domain.model.guess.city.City
import com.ray.guess.domain.repository.guess.city.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val cityDao: CityDao
) : CityRepository {
    override suspend fun getCityById(id: Long): City? {
        return cityDao.select(id)?.let {
            City(
                id = it.id,
                nameKorean = it.nameKorean,
                nameKanji = it.nameKanji,
                parentKorean = it.parentKorean,
                population = it.population,
                area = it.area,
                density = it.density,
                date = it.date,
            )
        }
    }

    override suspend fun getCityList(): List<City> {
        return cityDao.selectAll()
            .map {
                City(
                    id = it.id,
                    nameKorean = it.nameKorean,
                    nameKanji = it.nameKanji,
                    parentKorean = it.parentKorean,
                    population = it.population,
                    area = it.area,
                    density = it.density,
                    date = it.date,
                )
            }
    }

    override suspend fun getRandomCity(): City? {
        return cityDao.selectRandom()?.let {
            City(
                id = it.id,
                nameKorean = it.nameKorean,
                nameKanji = it.nameKanji,
                parentKorean = it.parentKorean,
                population = it.population,
                area = it.area,
                density = it.density,
                date = it.date,
            )
        }
    }
}
