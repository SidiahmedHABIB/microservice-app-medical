package com.rdvservice.service;

import com.rdvservice.entities.Rdv;
import com.rdvservice.repository.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceRdv implements IServiceRdv {
    private final RdvRepository rdvRepository;

    @Autowired
    public ServiceRdv(RdvRepository rdvRepository) {
        this.rdvRepository = rdvRepository;
    }

    @Override
    public Rdv getRdvById(int id) {
        return rdvRepository.findById(id).get();
    }

    @Override
    public Rdv addRdv(Rdv rdv) {
        // Check if the patient already has a rendezvous at the same date and time
//        boolean patientHasRdv = rdvRepository.existsByPatientIdAndDateRdv(
//                rdv.getPatient().getId(), rdv.getDateRdv());
//
//        // Check if the doctor already has a rendezvous at the same date and time
//        boolean medecinHasRdv = rdvRepository.existsByMedecinIdAndDateRdv(
//                rdv.getMedecin().getId(), rdv.getDateRdv());
//
//        if (patientHasRdv || medecinHasRdv) {
//            throw new IllegalArgumentException("Rendez-vous exists.");
//        }

        return rdvRepository.save(rdv);
    }

    @Override
    public List<Rdv> getAllRdvs() {
        return rdvRepository.findAll();
    }

    @Override
    public List<Rdv> findByPatientIdAndDate( LocalDate date) {
        return rdvRepository.findByDateRdvIgnoringTime(date);
    }

    @Override
    public List<Rdv> findByMedecinIdAndDate(Integer medecinId, LocalDateTime date) {
        return rdvRepository.findByMedecinIdAndDateRdv(medecinId, date);
    }
}
