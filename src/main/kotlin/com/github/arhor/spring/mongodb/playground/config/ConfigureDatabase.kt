package com.github.arhor.spring.mongodb.playground.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.time.Clock
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Optional
import java.util.function.Supplier

@Configuration(proxyBeanMethods = false)
@EnableMongoAuditing(modifyOnCreate = false, dateTimeProviderRef = "currentDateTimeProvider")
@EnableMongoRepositories(basePackages = ["com.github.arhor.spring.mongodb.playground.data.repository"])
@EnableTransactionManagement
class ConfigureDatabase {

    @Bean
    fun currentDateTimeSupplier() = Supplier {
        val systemUTC = Clock.systemUTC()
        val timestamp = LocalDateTime.now(systemUTC)

        timestamp.truncatedTo(ChronoUnit.MILLIS)
    }

    @Bean
    fun currentDateTimeProvider(currentDateTimeSupplier: Supplier<LocalDateTime>) = DateTimeProvider {
        Optional.of(currentDateTimeSupplier.get())
    }
}
