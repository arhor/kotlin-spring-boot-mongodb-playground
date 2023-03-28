package com.github.arhor.spring.mongodb.playground.service.exception

abstract class EntityConditionException(
    /**
     * Name of the entity associated with exception
     */
    val entity: String,

    /**
     * Condition caused the exception, for example: id = 1
     */
    val condition: String,
) : RuntimeException()
