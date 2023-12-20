package com.ray.guess.di

import com.ray.guess.data.repository.guess.city.CityRepositoryImpl
import com.ray.guess.data.source.local.guess.city.CityDao
import com.ray.guess.data.source.local.guess.city.CityDaoImpl
import com.ray.guess.domain.repository.guess.city.CityRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindCityRepository(
        cityRepository: CityRepositoryImpl
    ): CityRepository

    @Binds
    @Singleton
    abstract fun bindSCityDao(
        cityDao: CityDaoImpl
    ): CityDao
}
