package com.github.arhor.spring.mongodb.playground.service.exception

import com.github.arhor.spring.mongodb.playground.service.exception.EntityConditionException

class EntityNotFoundException(entity: String, condition: String) : EntityConditionException(entity, condition)
