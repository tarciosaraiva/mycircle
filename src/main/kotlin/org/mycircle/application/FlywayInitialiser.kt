package org.mycircle.application

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import javax.sql.DataSource

@Configuration
open class FlywayInitialiser constructor(@Qualifier("usersDataSource") val usersDataSource: DataSource) {

    @PostConstruct
    fun migrateFlyway() {
        val flyway = Flyway()
        flyway.sqlMigrationPrefix = "U"
        flyway.dataSource = usersDataSource
        flyway.migrate()
    }

}
