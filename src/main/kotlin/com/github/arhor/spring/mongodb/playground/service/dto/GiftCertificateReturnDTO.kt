package com.github.arhor.spring.mongodb.playground.service.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class GiftCertificateReturnDTO(
    val id: String,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val duration: Int,
    val dateTimeCreated: LocalDateTime,
    val dateTimeUpdated: LocalDateTime?,
    var tags: List<TagReturnDTO>,
)
