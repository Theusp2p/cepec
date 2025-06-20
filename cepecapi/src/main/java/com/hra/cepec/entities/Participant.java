package com.hra.cepec.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String code;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 15)
    private String cpf;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @ManyToMany(mappedBy = "participants")
    private Set<Study> studies = new HashSet<>();

}
