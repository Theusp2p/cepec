package com.hra.cepec.controllers;

import com.hra.cepec.StudyNotFoundException;
import com.hra.cepec.entities.Study;
import com.hra.cepec.services.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("studies")
@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @GetMapping
    public ResponseEntity<List<Study>> findAll(){
        List<Study> studies = studyService.findAll();
        return ResponseEntity.ok(studies);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Study> findById(
            @PathVariable Long id){
        var study =  studyService.findById(id);
        if(study.isEmpty()){
            throw new StudyNotFoundException("Study com id: " + id + " not found");
        }
        return ResponseEntity.ok(study.get());
    }

}
