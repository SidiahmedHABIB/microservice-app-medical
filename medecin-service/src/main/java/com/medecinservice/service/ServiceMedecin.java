package com.medecinservice.service;

import com.medecinservice.entities.Medecin;
import com.medecinservice.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMedecin implements IServiceMedecin {
    private final MedecinRepository medecinRepository;

    @Autowired
    public ServiceMedecin(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }


    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin getById(int id) {
        return medecinRepository.findById(id).get();
    }
}
