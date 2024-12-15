package com.patientservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nom ;
    private  String prenom;
    private  int age;
    private  int tel;

}
