package com.github.arhor.spring.mongodb.playground.controller

import com.github.arhor.spring.mongodb.playground.service.GiftCertificateService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/gift-certificates")
class GiftCertificateController(
    private val giftCertificateService: GiftCertificateService,
) {

//    @GetMapping
//    fun getAllTags(): List<CertificateDTO> {
//        return service.findAll()
//    }
//
//    @GetMapping("/{certificateId}")
//    fun getTagById(@PathVariable certificateId: Long): CertificateDTO {
//        return service.findOne(certificateId)
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    fun createCertificate(@RequestBody certificate: CertificateDTO): ResponseEntity<CertificateDTO> {
//        val createdCertificate = service.create(certificate)
//
//        val location =
//            ServletUriComponentsBuilder.fromCurrentRequestUri()
//                .path("/{id}")
//                .build(createdCertificate.id)
//
//        return ResponseEntity.created(location).body(createdCertificate)
//    }
//
//    @PatchMapping
//    fun updateCertificate(@RequestBody certificate: CertificateDTO): CertificateDTO {
//        return service.update(certificate)
//    }
//
//    @DeleteMapping("/{certificateId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteCertificate(@PathVariable certificateId: Long) {
//        service.deleteById(certificateId)
//    }
}
