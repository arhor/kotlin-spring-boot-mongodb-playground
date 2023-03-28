package com.github.arhor.spring.mongodb.playground.data.repository

import com.github.arhor.spring.mongodb.playground.config.ConfigureDatabase
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Transactional
@DataMongoTest
@DirtiesContext
@Testcontainers(disabledWithoutDocker = true)
@ContextConfiguration(classes = [ConfigureDatabase::class])
internal abstract class RepositoryTestBase {

    companion object {
        @JvmStatic
        @Container
        private val db = MongoDBContainer("mongo:4.4")

        @JvmStatic
        @DynamicPropertySource
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri", db::getReplicaSetUrl)
        }
    }
}
