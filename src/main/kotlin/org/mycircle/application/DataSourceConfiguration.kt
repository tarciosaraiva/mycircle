package org.mycircle.application

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource


@Configuration
class DataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.data")
    fun dataDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.data")
    fun dataDataSource(): DataSource {
        return dataDataSourceProperties().initializeDataSourceBuilder().build()
    }

    @Bean
    @ConfigurationProperties("app.datasource.users")
    fun usersDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("app.datasource.users")
    fun usersDataSource(): DataSource {
        return usersDataSourceProperties().initializeDataSourceBuilder().build()
    }

}
