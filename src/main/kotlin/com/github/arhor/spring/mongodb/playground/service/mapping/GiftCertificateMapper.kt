package com.github.arhor.spring.mongodb.playground.service.mapping

import com.github.arhor.spring.mongodb.playground.data.model.GiftCertificate
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.GiftCertificateReturnDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MapStructConfig::class, uses = [TagMapper::class])
interface GiftCertificateMapper {

    fun mapGiftCertificateToReturnDto(giftCertificate: GiftCertificate): GiftCertificateReturnDTO

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "dateTimeCreated", ignore = true)
    @Mapping(target = "dateTimeUpdated", ignore = true)
    fun mapCreateDtoToGiftCertificate(dto: GiftCertificateCreateDTO): GiftCertificate
}
