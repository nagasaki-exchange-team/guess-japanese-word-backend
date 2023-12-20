package com.ray.guess.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val id: Long,
    val name: String,
    val age: Int,
)
