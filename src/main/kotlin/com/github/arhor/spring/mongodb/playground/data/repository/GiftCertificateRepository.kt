package com.github.arhor.spring.mongodb.playground.data.repository

import com.github.arhor.spring.mongodb.playground.data.model.GiftCertificate
import org.springframework.data.mongodb.repository.MongoRepository

interface GiftCertificateRepository : MongoRepository<GiftCertificate, String> {
}
