package com.ray.guess.di

import com.ray.guess.data.repository.StudentRepositoryImpl
import com.ray.guess.data.source.local.student.StudentDao
import com.ray.guess.data.source.local.student.StudentDaoImpl
import com.ray.guess.domain.repository.StudentRepository
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
