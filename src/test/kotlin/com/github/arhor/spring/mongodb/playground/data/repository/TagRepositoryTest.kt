package com.github.arhor.spring.mongodb.playground.data.repository

import com.github.arhor.spring.mongodb.playground.data.model.Tag
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class TagRepositoryTest : RepositoryTestBase() {

    @Autowired
    private lateinit var tagRepository: TagRepository

    @Test
    fun `should return list of tags by the provided list of tag names`() {
        // Given
        val testTag1 = tagRepository.insert(Tag(name = "test-tag-1"))
        val testTag2 = tagRepository.insert(Tag(name = "test-tag-2"))
        val testTag3 = tagRepository.insert(Tag(name = "test-tag-3"))

        // When
        val result = tagRepository.findTagsByNameIn(listOf(testTag1.name, testTag2.name))

        // Then
        assertThat(result)
            .isNotEmpty
            .containsExactly(testTag1, testTag2)
            .doesNotContain(testTag3)
    }

    @Test
    fun `should return an empty list of tags when empty list of tag names provided`() {
        // Given
        val tagNames = emptyList<String>()

        // When
        val result = tagRepository.findTagsByNameIn(tagNames)

        // Then
        assertThat(result)
            .isEmpty()
    }
}
