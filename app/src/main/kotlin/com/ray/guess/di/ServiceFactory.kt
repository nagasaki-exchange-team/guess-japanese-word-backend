package com.ray.guess.di

import com.ray.guess.presentation.guess.city.CityService
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DataModule::class
    ]
)
@Singleton
interface ServiceFactory {
    fun cityService(): CityService
}
