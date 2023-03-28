package com.github.arhor.spring.mongodb.playground.data.repository

import com.github.arhor.spring.mongodb.playground.data.model.Tag
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface TagRepository : MongoRepository<Tag, String> {

    @Query("{ name: { \$in: ?0 } }")
    fun findTagsByNameIn(tagNames: List<String>): List<Tag>
}
