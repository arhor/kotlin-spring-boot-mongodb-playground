package com.github.arhor.spring.mongodb.playground.service

import com.github.arhor.spring.mongodb.playground.service.dto.TagCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.TagReturnDTO

interface TagService {
    fun createNewTag(dto: TagCreateDTO): TagReturnDTO
    fun deleteTagById(tagId: String)
    fun getTagById(tagId: String): TagReturnDTO
    fun getTags(page: Int, size: Int): List<TagReturnDTO>
}
