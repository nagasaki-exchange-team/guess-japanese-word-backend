package com.ray.study.ktor.data.source.local.student

import com.ray.study.ktor.data.model.StudentEntity

interface StudentDao {
    suspend fun select(id: Long): StudentEntity?

    suspend fun selectAll(): List<StudentEntity>

    suspend fun insert(student: StudentEntity)

    suspend fun insertAll(students: List<StudentEntity>)
}
