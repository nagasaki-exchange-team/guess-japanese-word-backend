package com.ray.guess.domain.usecase.student

import com.ray.guess.domain.model.Student
import com.ray.guess.domain.repository.StudentRepository
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
