package com.ray.study.ktor.data.source.local.student

import com.ray.study.ktor.data.model.StudentEntity
import com.ray.study.ktor.data.source.local.RayDatabase
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import javax.inject.Inject

class StudentDaoImpl @Inject constructor(
    private val database: RayDatabase,
    private val studentTable: StudentTable
) : StudentDao {

    override suspend fun select(id: Long): StudentEntity? {
        return database.dbQuery {
            studentTable.select { studentTable.id eq id }
                .map(::mapStudent)
                .singleOrNull()
        }
    }

    override suspend fun selectAll(): List<StudentEntity> {
        return database.dbQuery {
            studentTable.selectAll()
                .map(::mapStudent)
        }
    }

    override suspend fun insert(student: StudentEntity) {
        return database.dbQuery {
            studentTable.insert {
                it[studentTable.id] = student.id
                it[studentTable.name] = student.name
                it[studentTable.age] = student.age
            }
        }
    }

    override suspend fun insertAll(students: List<StudentEntity>) {
        return database.dbQuery {
            students.forEach { student ->
                studentTable.insert {
                    it[studentTable.id] = student.id
                    it[studentTable.name] = student.name
                    it[studentTable.age] = student.age
                }
            }
        }
    }

    private fun mapStudent(row: ResultRow): StudentEntity {
        return StudentEntity(
            id = row[studentTable.id],
            name = row[studentTable.name],
            age = row[studentTable.age],
        )
    }
}
