package com.github.arhor.spring.mongodb.playground.service.exception

import com.github.arhor.spring.mongodb.playground.service.exception.EntityConditionException

class EntityDuplicateException(entity: String, condition: String) : EntityConditionException(entity, condition)
