package com.hra.cepec.services;

import com.hra.cepec.StudyNotFoundException;
import com.hra.cepec.entities.Participant;
import com.hra.cepec.entities.Study;
import com.hra.cepec.respositories.ParticipantRepository;
import com.hra.cepec.respositories.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;
    private final ParticipantRepository participantRepository;


    public List<Study> findAll() {
        return studyRepository.findAll();
    }


    public Optional<Study> findById(Long id) {
        return studyRepository.findById(id);
    }

    public Study update(Long studyId, Study study) {
        // 1. Busca o estudo existente (ou lança exceção)
        Study existingStudy = studyRepository.findById(studyId)
                .orElseThrow(() -> new StudyNotFoundException("Estudo não encontrado com ID: " + studyId));

        // 2. Valida consistência do ID (protege contra sobrescrita acidental)
        if (!studyId.equals(study.getId())) {
            throw new IllegalArgumentException("ID do estudo não corresponde ao ID da URL");
        }

        // 3. Copia as propriedades atualizáveis (exceto ID e campos imutáveis)
        existingStudy.setTitle(study.getTitle());
        existingStudy.setStatus(study.getStatus());
        // ... outros campos atualizáveis

        // 4. Salva e retorna a entidade gerenciada
        return studyRepository.save(existingStudy);
    }

    public Study create(Study values) {
        return studyRepository.save(values);
    }

    @Transactional
    public Participant addParticipant(String id, Participant participant) {
        Long longId = Long.parseLong(id);
        Study study = studyRepository.findById(longId)
                .orElseThrow(() -> new StudyNotFoundException("Study Not found com ID: " + longId));

        if(participant.getId() != null) {
            throw new IllegalArgumentException("Participant não deve ter ID preexistente");
        }

        study.addParticipant(participant);

        return participant;
    }

}
