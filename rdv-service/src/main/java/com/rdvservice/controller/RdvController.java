package com.rdvservice.controller;

import com.rdvservice.client.MedecinRestClient;
import com.rdvservice.client.PatientRestClient;
import com.rdvservice.entities.Rdv;
import com.rdvservice.model.Medecin;
import com.rdvservice.model.Patient;
import com.rdvservice.service.IServiceRdv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/rdv")
public class RdvController {
    private final IServiceRdv serviceRdv;
    private final PatientRestClient patientRestClient;
    private final MedecinRestClient medecinRestClient;

    public RdvController(IServiceRdv serviceRdv, PatientRestClient patientRestClient, MedecinRestClient medecinRestClient) {
        this.serviceRdv = serviceRdv;
        this.patientRestClient = patientRestClient;
        this.medecinRestClient = medecinRestClient;
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveRdv(@RequestBody Rdv rdv) {
        try {
            Rdv savedRdv = serviceRdv.addRdv(rdv);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRdv);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rdv> getRdvById(@PathVariable("id") int id) {
        Rdv rdv = serviceRdv.getRdvById(id);
        Patient patient = patientRestClient.getPatientById(rdv.getPatientId());
        Medecin medecin = medecinRestClient.getMedecinById(rdv.getMedecinId());
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        return ResponseEntity.ok(rdv);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rdv>> getAllRdvs() {
        List<Rdv> rdvs = serviceRdv.getAllRdvs();
        return ResponseEntity.ok(rdvs);
    }

    @GetMapping("/bydate/{date}")
    public ResponseEntity<List<Rdv>> getRdvsByPatientAndDate(
            @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Rdv> rdvs = serviceRdv.findByPatientIdAndDate(localDate);
        return ResponseEntity.ok(rdvs);
    }

    @GetMapping("/medecin/{medecinId}/date/{date}")
    public ResponseEntity<List<Rdv>> getRdvsByMedecinAndDate(
            @PathVariable Integer medecinId,
            @PathVariable String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        List<Rdv> rdvs = serviceRdv.findByMedecinIdAndDate(medecinId, localDateTime);
        return ResponseEntity.ok(rdvs);
    }
}
