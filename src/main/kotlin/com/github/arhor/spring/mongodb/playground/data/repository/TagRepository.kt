package com.github.arhor.spring.mongodb.playground.data.repository

import com.github.arhor.spring.mongodb.playground.data.model.Tag
import org.springframework.data.mongodb.repository.MongoRepository

interface TagRepository : MongoRepository<Tag, String> {
}
