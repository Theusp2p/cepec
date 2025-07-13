package com.hra.cepec.controllers.dtos;

import com.hra.cepec.entities.enums.StudyStatus;

public record StudyResponseListDTO(

        Long id,
        String title,
        StudyStatus status
) {
}
