package com.ray.guess.data.source.local

import com.ray.guess.data.source.local.guess.city.CityTable
import kotlinx.coroutines.Dispatchers
import org.h2.tools.Server
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class RayDatabase @Inject constructor(
    private val cityTable: CityTable
) {
    init {
        transaction(
            Database.connect(JDBC_URL, DRIVER_CLASS_NAME)
        ) {
            SchemaUtils.create(cityTable)
        }

        Server.createTcpServer(
            COMMAND_TCP_PORT,
            TCP_PORT,
            COMMAND_ALLOW_TCP
        ).start()
    }

    suspend fun <T> dbQuery(
        block: suspend () -> T
    ): T {
        return newSuspendedTransaction(Dispatchers.IO) { block() }
    }

    companion object {
        private const val DRIVER_CLASS_NAME = "org.h2.Driver"
        private const val JDBC_URL = "jdbc:h2:file:./database/guess"
        private const val COMMAND_TCP_PORT = "-tcpPort"
        private const val COMMAND_ALLOW_TCP = "-tcpAllowOthers"
        private const val TCP_PORT = "9092"
    }
}
