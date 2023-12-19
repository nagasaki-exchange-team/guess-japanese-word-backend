package com.ray.study.ktor.domain.usecase.student

import com.ray.study.ktor.domain.model.Student
import com.ray.study.ktor.domain.repository.StudentRepository
import javax.inject.Inject

class GetStudentListUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(): List<Student> {
        return studentRepository.getStudentList()
    }
}
