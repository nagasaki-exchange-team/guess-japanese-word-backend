package com.ray.guess.domain.repository

import com.ray.guess.domain.model.Student

interface StudentRepository {

    suspend fun getStudentById(id: Long): Student?

    suspend fun getStudentList(): List<Student>
}
