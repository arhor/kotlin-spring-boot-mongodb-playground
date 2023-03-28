package com.github.arhor.spring.mongodb.playground.service.impl

import com.github.arhor.spring.mongodb.playground.data.repository.GiftCertificateRepository
import com.github.arhor.spring.mongodb.playground.service.GiftCertificateService
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateReturnDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateUpdateDTO
import com.github.arhor.spring.mongodb.playground.service.mapping.GiftCertificateMapper
import org.springframework.stereotype.Service

@Service
class GiftCertificateServiceImpl(
    private val giftCertificateMapper: GiftCertificateMapper,
    private val giftCertificateRepository: GiftCertificateRepository,
) : GiftCertificateService {

    override fun getGiftCertificatesPaged(page: Int, size: Int): List<GiftCertificateReturnDTO> {
        TODO("Not yet implemented")
    }

    override fun getGiftCertificateById(certificateId: String): GiftCertificateReturnDTO {
        TODO("Not yet implemented")
    }

    override fun createGiftCertificate(dto: GiftCertificateCreateDTO): GiftCertificateReturnDTO {
        TODO("Not yet implemented")
    }

    override fun updateGiftCertificate(dto: GiftCertificateUpdateDTO): GiftCertificateReturnDTO {
        TODO("Not yet implemented")
    }

    override fun deleteGiftCertificateById(certificateId: String) {
        TODO("Not yet implemented")
    }
}
