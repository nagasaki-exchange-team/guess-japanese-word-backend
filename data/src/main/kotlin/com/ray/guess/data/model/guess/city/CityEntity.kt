package com.ray.guess.data.model.guess.city

data class CityEntity(
    val id: Long,
    val nameKorean: String,
    val nameKanji: String,
    val prefecture: String,
    val population: Int,
    val area: Int,
    val density: Int,
)
