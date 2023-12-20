package com.ray.guess.data.source.local.guess.city

import javax.inject.Inject
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

class CityTable @Inject constructor() : Table() {

    val id = long("id").autoIncrement()

    val nameKorean = varchar("name_korean", 128)

    val nameKanji = varchar("name_kanji", 128)

    val parentKorean = varchar("parent_korean", 128)

    val population = integer("population")

    val area = integer("area")

    val density = integer("density")

    val date = long("date")

    override val primaryKey = PrimaryKey(id)
}
