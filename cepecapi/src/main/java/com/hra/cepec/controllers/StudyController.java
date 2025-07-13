package com.hra.cepec.controllers;

import com.hra.cepec.StudyNotFoundException;
import com.hra.cepec.controllers.dtos.StudyResponseDetailsDTO;
import com.hra.cepec.controllers.dtos.StudyResponseListDTO;
import com.hra.cepec.controllers.mappers.StudyResponseDetailsMapper;
import com.hra.cepec.controllers.mappers.StudyResponseListMapper;
import com.hra.cepec.entities.Participant;
import com.hra.cepec.entities.Study;
import com.hra.cepec.respositories.ParticipantRepository;
import com.hra.cepec.services.ParticipantService;
import com.hra.cepec.services.StudyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("studies")
@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;
    private final StudyResponseListMapper studyResponseListMapper;
    private final StudyResponseDetailsMapper studyResponseDetailsMapper;
    private final ParticipantService participantService;

    @GetMapping
    public ResponseEntity<List<StudyResponseListDTO>> findAll() {
        List<Study> studies = studyService.findAll();
        List<StudyResponseListDTO> dtos = studies.stream()
                .map(studyResponseListMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Study> create(@RequestBody Study values) {
        Study saved = studyService.create(values);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/{id}/participants")
    public ResponseEntity<Participant> addParticipant(
            @PathVariable String id,
            @Valid @RequestBody Participant participant) {  // Adicionado @Valid

        if(participant.getId() != null) {
            throw new IllegalArgumentException("Novo participant não deve ter ID");
        }
        Participant saved = studyService.addParticipant(id, participant);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }



    @GetMapping("/{id}")
    public ResponseEntity<StudyResponseDetailsDTO> findById(
            @PathVariable Long id){
        Study study = studyService.findById(id).orElseThrow( () -> new StudyNotFoundException("Study com id: \" + id + \" not found"));

        StudyResponseDetailsDTO dto = studyResponseDetailsMapper.toDTO(study);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Study> update(
            @PathVariable String id,
            @RequestBody Study study) {

        Long studyId = Long.parseLong(id);

        if(study.getId() != studyId){
            throw new StudyNotFoundException("Study com id: " + id + " not found");
        }

        Study updatedStudy = studyService.update(studyId, study);
        return ResponseEntity.ok(updatedStudy);
    }

}
