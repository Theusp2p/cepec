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

    @Column(nullable = false, length = 20)
    private String code;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 50)
    private String phase;

    @Column(nullable = false, length = 50)
    private String sponsor;

    @Column(name = "type_study", nullable = false, length = 50)
    private String typeStudy;

    @Column(nullable = true, length = 255)
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
    @Column(nullable = false, length = 15)
    private StudyStatus status;

    @Column(nullable = true, length = 80)
    private String mainResponsible;

    @Column(nullable = true, length = 80)
    private String emailContact;

    @Column(nullable = true, length = 20)
    private String phoneContact;

    @Column(nullable = true, length = 100)
    private String protocolDescription;

    @Column(nullable = true, length = 500)
    private String observations;

}
