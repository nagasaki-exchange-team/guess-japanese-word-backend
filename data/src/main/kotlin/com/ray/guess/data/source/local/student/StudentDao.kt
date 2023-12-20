package com.ray.guess.data.source.local.student

import com.ray.guess.data.model.StudentEntity

interface StudentDao {
    suspend fun select(id: Long): StudentEntity?

    suspend fun selectAll(): List<StudentEntity>

    suspend fun insert(student: StudentEntity)

    suspend fun insertAll(students: List<StudentEntity>)
}
