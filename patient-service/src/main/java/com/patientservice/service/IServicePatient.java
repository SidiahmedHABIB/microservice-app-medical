package com.patientservice.service;


import com.patientservice.entities.Patient;

import java.util.List;

public interface IServicePatient {
    List<Patient> getAllPatients();
    Patient getPatientById(int id);
   }
