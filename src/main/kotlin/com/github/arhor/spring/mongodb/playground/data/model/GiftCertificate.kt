package com.github.arhor.spring.mongodb.playground.data.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Immutable
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Immutable
@Document("gift_certificates")
data class GiftCertificate(
    @Id
    val id: String? = null,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val duration: Int,
    @Version
    val version: Long = 0,
    @CreatedDate
    val dateTimeCreated: LocalDateTime? = null,
    @LastModifiedDate
    val dateTimeUpdated: LocalDateTime? = null,
    @DBRef
    val tags: List<Tag> = emptyList(),
)
