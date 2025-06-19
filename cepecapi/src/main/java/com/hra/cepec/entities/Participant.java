package com.hra.cepec.entities;

import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Participant {



    @ManyToMany(mappedBy = "participants")
    private Set<Study> studies = new HashSet<>();

}
