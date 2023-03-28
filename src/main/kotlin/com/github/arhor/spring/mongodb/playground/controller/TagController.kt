package com.github.arhor.spring.mongodb.playground.controller

import com.github.arhor.spring.mongodb.playground.service.TagService
import com.github.arhor.spring.mongodb.playground.service.dto.TagCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.TagReturnDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/tags")
class TagController(
    private val tagService: TagService,
) {

    @PostMapping
    fun createNewTag(@RequestBody tag: TagCreateDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<*> {
        val createdTag = tagService.createNewTag(tag)
        val location = uriBuilder.path("/{tagId}").build(createdTag.id)

        return ResponseEntity.created(location).body(createdTag)
    }

    @DeleteMapping("/{tagId}")
    fun deleteTagById(@PathVariable tagId: String) {
        tagService.deleteTagById(tagId)
    }

    @GetMapping("/{tagId}")
    fun getTagById(@PathVariable tagId: String): TagReturnDTO {
        return tagService.getTagById(tagId)
    }

    @GetMapping
    fun getTags(
        @RequestParam(defaultValue = DEFAULT_PAGE) page: Int,
        @RequestParam(defaultValue = DEFAULT_SIZE) size: Int,
    ): List<TagReturnDTO> {
        return tagService.getTags(page, size)
    }

    companion object {
        private const val DEFAULT_PAGE = "1"
        private const val DEFAULT_SIZE = "10"
    }
}
