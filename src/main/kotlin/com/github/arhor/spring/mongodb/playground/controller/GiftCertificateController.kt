package com.github.arhor.spring.mongodb.playground.controller

import com.github.arhor.spring.mongodb.playground.service.GiftCertificateService
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateReturnDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateUpdateDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/gift-certificates")
class GiftCertificateController(
    private val giftCertificateService: GiftCertificateService,
) {

    @GetMapping
    fun getGiftCertificates(
        @RequestParam(defaultValue = DEFAULT_PAGE) page: Int,
        @RequestParam(defaultValue = DEFAULT_SIZE) size: Int,
    ): List<GiftCertificateReturnDTO> {
        return giftCertificateService.getGiftCertificatesPaged(page, size)
    }

    @GetMapping("/{certificateId}")
    fun getGiftCertificateById(@PathVariable certificateId: String): GiftCertificateReturnDTO {
        return giftCertificateService.getGiftCertificateById(certificateId)
    }

    @PostMapping
    fun createGiftCertificate(
        @RequestBody dto: GiftCertificateCreateDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<GiftCertificateReturnDTO> {
        val createdCertificate = giftCertificateService.createGiftCertificate(dto)
        val location = uriBuilder.path("/{certificateId}").build(createdCertificate.id)

        return ResponseEntity.created(location).body(createdCertificate)
    }

    @PatchMapping
    fun updateGiftCertificate(@RequestBody dto: GiftCertificateUpdateDTO): GiftCertificateReturnDTO {
        return giftCertificateService.updateGiftCertificate(dto)
    }

    @DeleteMapping("/{certificateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCertificate(@PathVariable certificateId: String) {
        giftCertificateService.deleteGiftCertificateById(certificateId)
    }
}
