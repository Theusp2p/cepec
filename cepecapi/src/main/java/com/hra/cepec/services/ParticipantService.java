package com.hra.cepec.services;

import com.hra.cepec.StudyNotFoundException;
import com.hra.cepec.entities.Participant;
import com.hra.cepec.entities.Study;
import com.hra.cepec.respositories.ParticipantRepository;
import com.hra.cepec.respositories.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final StudyRepository studyRepository;


}
