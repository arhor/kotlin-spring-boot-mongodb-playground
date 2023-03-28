package com.github.arhor.spring.mongodb.playground.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("tags")
data class Tag(
    @Id
    val id: String? = null,

    @Indexed(unique = true)
    val name: String,
)
