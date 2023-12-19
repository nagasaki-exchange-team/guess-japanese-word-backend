package com.ray.study.ktor.domain.usecase.student

import com.ray.study.ktor.domain.model.Student
import com.ray.study.ktor.domain.repository.StudentRepository
import javax.inject.Inject

class GetStudentByIdUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(
        id: Long
    ): Student? {
        return studentRepository.getStudentById(id)
    }
}
