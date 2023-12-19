package com.ray.study.ktor.data.source.local

import com.ray.study.ktor.data.source.local.student.StudentTable
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class RayDatabase @Inject constructor(
    private val studentTable: StudentTable
) {
    init {
        transaction(
            Database.connect(JDBC_URL, DRIVER_CLASS_NAME)
        ) {
            SchemaUtils.create(studentTable)
        }
    }

    suspend fun <T> dbQuery(
        block: suspend () -> T
    ): T {
        return newSuspendedTransaction(Dispatchers.IO) { block() }
    }

    companion object {
        private const val DRIVER_CLASS_NAME = "org.h2.Driver"
        private const val JDBC_URL = "jdbc:h2:file:./database/student"
    }
}
