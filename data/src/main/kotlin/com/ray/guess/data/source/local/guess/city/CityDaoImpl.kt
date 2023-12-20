package com.ray.guess.data.source.local.guess.city

import com.ray.guess.data.model.guess.city.CityEntity
import com.ray.guess.data.source.local.RayDatabase
import javax.inject.Inject
import org.jetbrains.exposed.sql.Random
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class CityDaoImpl @Inject constructor(
    private val database: RayDatabase,
    private val cityTable: CityTable
) : CityDao {

    override suspend fun select(id: Long): CityEntity? {
        return database.dbQuery {
            cityTable.select { cityTable.id eq id }
                .limit(1)
                .map(::mapCity)
                .singleOrNull()
        }
    }

    override suspend fun selectAll(): List<CityEntity> {
        return database.dbQuery {
            cityTable.selectAll()
                .orderBy(cityTable.id to SortOrder.ASC)
                .map(::mapCity)
        }
    }

    override suspend fun selectRandom(): CityEntity? {
        return database.dbQuery {
            cityTable
                .selectAll()
                .orderBy(Random())
                .limit(1)
                .map(::mapCity)
                .singleOrNull()
        }
    }

    override suspend fun insert(city: CityEntity) {
        return database.dbQuery {
            cityTable.insert {
                it[cityTable.id] = city.id
                it[cityTable.nameKorean] = city.nameKorean
                it[cityTable.nameKanji] = city.nameKanji
                it[cityTable.parentKorean] = city.parentKorean
                it[cityTable.population] = city.population
                it[cityTable.area] = city.area
                it[cityTable.density] = city.density
                it[cityTable.date] = city.date
            }
        }
    }

    override suspend fun insertAll(cities: List<CityEntity>) {
        return database.dbQuery {
            cities.forEach { city ->
                cityTable.insert {
                    it[cityTable.id] = city.id
                    it[cityTable.nameKorean] = city.nameKorean
                    it[cityTable.nameKanji] = city.nameKanji
                    it[cityTable.parentKorean] = city.parentKorean
                    it[cityTable.population] = city.population
                    it[cityTable.area] = city.area
                    it[cityTable.density] = city.density
                    it[cityTable.date] = city.date
                }
            }
        }
    }

    private fun mapCity(row: ResultRow): CityEntity {
        return CityEntity(
            id = row[cityTable.id],
            nameKorean = row[cityTable.nameKorean],
            nameKanji = row[cityTable.nameKanji],
            parentKorean = row[cityTable.parentKorean],
            population = row[cityTable.population],
            area = row[cityTable.area],
            density = row[cityTable.density],
            date = row[cityTable.date],
        )
    }
}
