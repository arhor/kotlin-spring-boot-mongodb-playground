package com.github.arhor.spring.mongodb.playground.service

import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateReturnDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateUpdateDTO

interface GiftCertificateService {
    fun getGiftCertificatesPaged(page: Int, size: Int): List<GiftCertificateReturnDTO>
    fun getGiftCertificateById(certificateId: String): GiftCertificateReturnDTO
    fun createGiftCertificate(dto: GiftCertificateCreateDTO): GiftCertificateReturnDTO
    fun updateGiftCertificate(certificateId: String, dto: GiftCertificateUpdateDTO): GiftCertificateReturnDTO
    fun deleteGiftCertificateById(certificateId: String)
}
