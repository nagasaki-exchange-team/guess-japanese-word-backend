package com.ray.guess.data.source.local.guess.city

import javax.inject.Inject
import org.jetbrains.exposed.sql.Table

class CityTable @Inject constructor() : Table() {

    val id = long("id").autoIncrement()

    val nameKorean = varchar("korean_name", 128)

    val nameKanji = varchar("japanese_name", 128)

    val prefecture = varchar("prefecture", 128)

    val population = integer("population")

    val area = integer("area")

    val density = integer("density")

    override val primaryKey = PrimaryKey(id)
}
