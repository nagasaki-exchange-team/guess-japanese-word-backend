package com.ray.guess.domain.model.guess.city

import kotlinx.serialization.Serializable

@Serializable
data class City(
    val id: Long,
    val nameKorean: String,
    val nameKanji: String,
    val prefecture: String,
    val population: Int,
    val area: Int,
    val density: Int,
)
