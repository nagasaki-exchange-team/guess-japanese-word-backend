package com.ray.study.ktor.di

import com.ray.study.ktor.data.repository.StudentRepositoryImpl
import com.ray.study.ktor.data.source.local.student.StudentDao
import com.ray.study.ktor.data.source.local.student.StudentDaoImpl
import com.ray.study.ktor.domain.repository.StudentRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindStudentRepository(
        studentRepository: StudentRepositoryImpl
    ): StudentRepository

    @Binds
    @Singleton
    abstract fun bindStudentDao(
        studentDao: StudentDaoImpl
    ): StudentDao
}
