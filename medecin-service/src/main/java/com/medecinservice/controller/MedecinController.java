package com.medecinservice.controller;

import com.medecinservice.entities.Medecin;
import com.medecinservice.service.IServiceMedecin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {
    private final IServiceMedecin iServiceMedecin;

    public MedecinController(IServiceMedecin iServiceMedecin) {
        this.iServiceMedecin = iServiceMedecin;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Medecin>> getAllMedecins() {
        List<Medecin> medecins = iServiceMedecin.getAllMedecins();
        return ResponseEntity.ok(medecins);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable("id") int id) {
        Medecin medecin = iServiceMedecin.getById(id);
        return ResponseEntity.ok(medecin);
    }
}
