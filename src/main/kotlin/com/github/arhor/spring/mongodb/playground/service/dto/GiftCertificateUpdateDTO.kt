package com.github.arhor.spring.mongodb.playground.service.dto

import java.math.BigDecimal

data class GiftCertificateUpdateDTO(
    val name: String? = null,
    val description: String? = null,
    val price: BigDecimal? = null,
    val duration: Int? = null,
    var tags: List<TagCreateDTO>? = null,
)
