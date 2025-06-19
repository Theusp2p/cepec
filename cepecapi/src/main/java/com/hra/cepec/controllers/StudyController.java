package com.hra.cepec.controllers;

import com.hra.cepec.entities.Study;
import com.hra.cepec.services.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    public ResponseEntity<List<Study>> findAll(){
        List<Study> studies = studyService.findAll();
        return ResponseEntity.ok(studies);
    }

}
