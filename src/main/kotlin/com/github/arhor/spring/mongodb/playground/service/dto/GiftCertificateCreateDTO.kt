package com.github.arhor.spring.mongodb.playground.service.dto

import java.math.BigDecimal

data class GiftCertificateCreateDTO(
    val name: String,
    val description: String,
    val price: BigDecimal,
    val duration: Int,
    var tags: List<TagCreateDTO> = emptyList(),
)
