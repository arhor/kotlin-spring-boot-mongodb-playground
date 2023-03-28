package com.github.arhor.spring.mongodb.playground.service.mapping

import com.github.arhor.spring.mongodb.playground.data.model.Tag
import com.github.arhor.spring.mongodb.playground.service.dto.TagCreateDTO
import com.github.arhor.spring.mongodb.playground.service.dto.TagReturnDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MapStructConfig::class)
interface TagMapper {

    fun mapTagToReturnDto(tag: Tag): TagReturnDTO

    @Mapping(target = "id", ignore = true)
    fun mapCreateDtoToTag(dto: TagCreateDTO): Tag
}
