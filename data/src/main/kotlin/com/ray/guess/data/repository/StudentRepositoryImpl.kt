package com.ray.guess.data.repository

import com.ray.guess.data.source.local.student.StudentDao
import com.ray.guess.domain.model.Student
import com.ray.guess.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentDao: StudentDao
) : StudentRepository {
    override suspend fun getStudentById(id: Long): Student? {
        return studentDao.select(id)?.let {
            Student(
                id = it.id,
                name = it.name,
                age = it.age
            )
        }
    }

    override suspend fun getStudentList(): List<Student> {
        return studentDao.selectAll()
            .map {
                Student(
                    id = it.id,
                    name = it.name,
                    age = it.age
                )
            }
    }
}
