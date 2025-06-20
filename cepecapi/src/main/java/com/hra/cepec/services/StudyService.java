package com.hra.cepec.services;

import com.hra.cepec.StudyNotFoundException;
import com.hra.cepec.entities.Study;
import com.hra.cepec.respositories.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;


    public List<Study> findAll(){
        return studyRepository.findAll();
    }


    public Optional<Study> findById(Long id) {
        return studyRepository.findById(id);
    }
}
