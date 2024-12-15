package com.rdvservice.client;

import com.rdvservice.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientRestClient {
    @GetMapping("/api/patient/{id}")
    Patient getPatientById(@PathVariable("id") int id);
}
