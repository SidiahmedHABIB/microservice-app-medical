package com.rdvservice.service;



import com.rdvservice.entities.Rdv;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IServiceRdv {
    Rdv getRdvById(int id);
    Rdv addRdv(Rdv rdv);
    List<Rdv> getAllRdvs();
    List<Rdv> findByPatientIdAndDate(LocalDate date);
    List<Rdv> findByMedecinIdAndDate(Integer medecinId, LocalDateTime date);
}
