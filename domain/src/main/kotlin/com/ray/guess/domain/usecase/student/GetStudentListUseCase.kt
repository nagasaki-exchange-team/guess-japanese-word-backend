package com.ray.guess.domain.usecase.student

import com.ray.guess.domain.model.Student
import com.ray.guess.domain.repository.StudentRepository
import javax.inject.Inject

class GetStudentListUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(): List<Student> {
        return studentRepository.getStudentList()
    }
}
