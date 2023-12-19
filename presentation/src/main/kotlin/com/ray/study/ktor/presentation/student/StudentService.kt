package com.ray.study.ktor.presentation.student

import com.ray.study.ktor.domain.usecase.student.GetStudentByIdUseCase
import com.ray.study.ktor.domain.usecase.student.GetStudentListUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.util.pipeline.PipelineContext
import javax.inject.Inject

class StudentService @Inject constructor(
    private val getStudentByIdUseCase: GetStudentByIdUseCase,
    private val getStudentListUseCase: GetStudentListUseCase
) {

    suspend fun onGetStudentCall(context: PipelineContext<Unit, ApplicationCall>) = with(context) {
        val id = call.parameters["id"] ?: return call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        val student = id.toLongOrNull()?.let {
            getStudentByIdUseCase(id = it)
        } ?: return call.respondText(
            "No student with id $id",
            status = HttpStatusCode.NotFound
        )

        call.respond(student)
    }

    suspend fun onGetStudentListCall(context: PipelineContext<Unit, ApplicationCall>) = with(context) {
        val students = getStudentListUseCase()
        call.respond(students)
    }
}
