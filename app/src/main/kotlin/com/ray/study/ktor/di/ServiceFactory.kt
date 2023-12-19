package com.ray.study.ktor.di

import com.ray.study.ktor.presentation.student.StudentService
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DataModule::class
    ]
)
@Singleton
interface ServiceFactory {
    fun studentService(): StudentService
}
