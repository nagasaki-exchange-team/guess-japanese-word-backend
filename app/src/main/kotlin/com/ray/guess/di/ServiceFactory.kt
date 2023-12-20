package com.ray.guess.di

import com.ray.guess.presentation.student.StudentService
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
