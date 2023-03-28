package com.github.arhor.spring.mongodb.playground.service.impl

import com.github.arhor.spring.mongodb.playground.data.repository.TagRepository
import com.github.arhor.spring.mongodb.playground.service.TagService
import com.github.arhor.spring.mongodb.playground.service.dto.TagCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.TagReturnDTO
import com.github.arhor.spring.mongodb.playground.service.exception.EntityNotFoundException
import com.github.arhor.spring.mongodb.playground.service.mapping.TagMapper
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TagServiceImpl(
    private val tagMapper: TagMapper,
    private val tagRepository: TagRepository,
) : TagService {

    override fun createNewTag(dto: TagCreateDTO): TagReturnDTO {
        return tagMapper.mapCreateDtoToTag(dto)
            .let(tagRepository::insert)
            .let(tagMapper::mapTagToReturnDto)
    }

    override fun deleteTagById(tagId: String) {
        if (!tagRepository.existsById(tagId)) {
            throw EntityNotFoundException("Tag", "id = $tagId")
        }
        tagRepository.deleteById(tagId)
    }

    override fun getTagById(tagId: String): TagReturnDTO {
        return tagRepository.findByIdOrNull(tagId)?.let(tagMapper::mapTagToReturnDto)
            ?: throw EntityNotFoundException("Tag", "id = $tagId")
    }

    override fun getTags(page: Int, size: Int): List<TagReturnDTO> {
        val pageRequest = PageRequest.of(page.asZeroBasedIndex(), size)
        val pagedResult = tagRepository.findAll(pageRequest)

        return pagedResult.map(tagMapper::mapTagToReturnDto).toList()
    }
}
