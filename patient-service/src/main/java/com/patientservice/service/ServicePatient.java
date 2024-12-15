package com.patientservice.service;

import com.patientservice.entities.Patient;
import com.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePatient implements IServicePatient {
    private final PatientRepository patientRepository;

    @Autowired
    public ServicePatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id).get();
    }
}
