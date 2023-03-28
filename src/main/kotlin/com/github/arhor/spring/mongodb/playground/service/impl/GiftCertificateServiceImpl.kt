package com.github.arhor.spring.mongodb.playground.service.impl

import com.github.arhor.spring.mongodb.playground.data.model.Tag
import com.github.arhor.spring.mongodb.playground.data.repository.GiftCertificateRepository
import com.github.arhor.spring.mongodb.playground.data.repository.TagRepository
import com.github.arhor.spring.mongodb.playground.service.GiftCertificateService
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateReturnDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateUpdateDTO
import com.github.arhor.spring.mongodb.playground.service.exception.EntityNotFoundException
import com.github.arhor.spring.mongodb.playground.service.mapping.GiftCertificateMapper
import com.github.arhor.spring.mongodb.playground.service.mapping.TagMapper
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GiftCertificateServiceImpl(
    private val giftCertificateMapper: GiftCertificateMapper,
    private val giftCertificateRepository: GiftCertificateRepository,
    private val tagMapper: TagMapper,
    private val tagRepository: TagRepository,
) : GiftCertificateService {

    override fun getGiftCertificatesPaged(page: Int, size: Int): List<GiftCertificateReturnDTO> {
        val pageRequest = PageRequest.of(page.asZeroBasedIndex(), size)
        val pagedResult = giftCertificateRepository.findAll(pageRequest)

        return pagedResult.map { giftCertificateMapper.mapGiftCertificateToReturnDto(it) }.toList()
    }

    override fun getGiftCertificateById(certificateId: String): GiftCertificateReturnDTO {
        return giftCertificateRepository.findByIdOrNull(certificateId)
            ?.let(giftCertificateMapper::mapGiftCertificateToReturnDto)
            ?: throw EntityNotFoundException("GiftCertificate", "id = $certificateId")
    }

    @Transactional
    override fun createGiftCertificate(dto: GiftCertificateCreateDTO): GiftCertificateReturnDTO {
        return giftCertificateMapper
            .mapCreateDtoToGiftCertificate(dto)
            .let { it.copy(tags = materializeTags(it.tags)) }
            .let { giftCertificateRepository.insert(it) }
            .let { giftCertificateMapper.mapGiftCertificateToReturnDto(it) }
    }

    @Retryable(
        retryFor = [OptimisticLockingFailureException::class],
        maxAttemptsExpression = "\${application-props.retry-attempts}",
    )
    @Transactional
    override fun updateGiftCertificate(certificateId: String, dto: GiftCertificateUpdateDTO): GiftCertificateReturnDTO {
        var giftCertificate = giftCertificateRepository.findByIdOrNull(certificateId)
            ?: throw EntityNotFoundException("GiftCertificate", "id = $certificateId")

        dto.name?.let {
            giftCertificate = giftCertificate.copy(name = it)
        }
        dto.description?.let {
            giftCertificate = giftCertificate.copy(description = it)
        }
        dto.price?.let {
            giftCertificate = giftCertificate.copy(price = it)
        }
        dto.duration?.let {
            giftCertificate = giftCertificate.copy(duration = it)
        }
        dto.tags?.let {
            giftCertificate = giftCertificate.copy(tags = it.map(tagMapper::mapCreateDtoToTag).let(::materializeTags))
        }

        return giftCertificateRepository
            .save(giftCertificate)
            .let(giftCertificateMapper::mapGiftCertificateToReturnDto)
    }

    override fun deleteGiftCertificateById(certificateId: String) {
        if (!giftCertificateRepository.existsById(certificateId)) {
            throw EntityNotFoundException("GiftCertificate", "id = $certificateId")
        }
        giftCertificateRepository.deleteById(certificateId)
    }

    private fun materializeTags(tags: List<Tag>): List<Tag> {
        if (tags.isEmpty()) {
            return emptyList()
        }

        val tagNames = tags.mapNotNull(Tag::name)
        val existingTags = tagRepository.findTagsByNameIn(tagNames)
        val existingTagNames = existingTags.map(Tag::name)

        val createdTags =
            tags.filterNot { existingTagNames.contains(it.name) }
                .map(tagRepository::insert)

        return existingTags + createdTags
    }
}
