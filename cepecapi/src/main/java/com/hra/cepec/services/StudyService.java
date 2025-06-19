package com.hra.cepec.services;

import com.hra.cepec.entities.Study;
import com.hra.cepec.respositories.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    public List<Study> findAll(){
        return studyRepository.findAll();
    }



}
