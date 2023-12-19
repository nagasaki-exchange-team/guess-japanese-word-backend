package com.ray.study.ktor.data.source.local.student

import org.jetbrains.exposed.sql.Table
import javax.inject.Inject

class StudentTable @Inject constructor() : Table() {

    val id = long("id").autoIncrement()

    val name = varchar("name", 128)

    val age = integer("age")

    override val primaryKey = PrimaryKey(id)
}
