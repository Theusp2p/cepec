package com.hra.cepec.controllers.dtos;

import com.hra.cepec.entities.Participant;
import com.hra.cepec.entities.enums.StudyStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

public record StudyResponseDetailsDTO(
        Long id,
        String code,
        String title,
        String phase,
        String sponsor,
        String typeStudy,
        String objective,
        LocalDate startDate,
        LocalDate endDate,
        StudyStatus status,
        String mainResponsible,
        String emailContact,
        String phoneContact,
        String protocolDescription,
        String observations
) {
}
