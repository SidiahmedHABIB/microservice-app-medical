package com.rdvservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rdvservice.model.Medecin;
import com.rdvservice.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Entity
public class Rdv {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String etat ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateRdv;
    private int patientId;
    private int medecinId;
    @Transient
    private Patient patient;
    @Transient
    private Medecin medecin;

}
