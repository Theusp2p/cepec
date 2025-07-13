package com.hra.cepec.controllers.mappers;

import com.hra.cepec.controllers.dtos.StudyResponseListDTO;
import com.hra.cepec.entities.Study;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudyResponseListMapper {

    StudyResponseListDTO toDTO(Study study);

}
