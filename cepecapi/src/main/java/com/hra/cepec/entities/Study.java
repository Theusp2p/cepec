package com.hra.cepec.entities;

import com.hra.cepec.entities.enums.StudyStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String phase;

    @Column(nullable = false)
    private String sponsor;

    @Column(name = "type_study", nullable = false)
    private String typeStudy;

    @Column(nullable = true)
    private String objective;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "study_participant",
            joinColumns = @JoinColumn(name = "study_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private Set<Participant> participants = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudyStatus status;

    @Column(nullable = true)
    private String mainResponsible;

    @Column(nullable = true)
    private String emailContact;

    @Column(nullable = true)
    private String phoneContact;

    @Column(nullable = true)
    private String protocolDescription;

    @Column(nullable = true)
    private String observations;

}
