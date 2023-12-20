package com.ray.guess.data.source.local.guess.city

import com.ray.guess.data.model.guess.city.CityEntity

interface CityDao {
    suspend fun select(id: Long): CityEntity?

    suspend fun selectAll(): List<CityEntity>

    suspend fun selectRandom(): CityEntity?

    suspend fun insert(city: CityEntity)

    suspend fun insertAll(cities: List<CityEntity>)
}
