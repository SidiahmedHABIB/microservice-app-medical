package com.patientservice.controller;

import com.patientservice.entities.Patient;
import com.patientservice.service.IServicePatient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final IServicePatient iServicePatient;

    public PatientController(IServicePatient iServicePatient) {
        this.iServicePatient = iServicePatient;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllMedecins() {
        List<Patient> patients = iServicePatient.getAllPatients();
        return ResponseEntity.ok(patients);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id) {
        Patient patients = iServicePatient.getPatientById(id);
        return ResponseEntity.ok(patients);
    }

}
