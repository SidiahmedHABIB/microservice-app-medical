package com.rdvservice.repository;

import com.rdvservice.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {
    @Query("SELECT r FROM Rdv r WHERE FUNCTION('DATE', r.dateRdv) = :date ORDER BY r.dateRdv ASC")
    List<Rdv> findByDateRdvIgnoringTime(LocalDate date);
    List<Rdv> findByMedecinIdAndDateRdv(int medecinId, LocalDateTime dateRdv);

    // Check if a Rdv exists for a given patient and date
    boolean existsByPatientIdAndDateRdv(Integer patientId, LocalDateTime dateRdv);

    // Check if a Rdv exists for a given doctor and date
    boolean existsByMedecinIdAndDateRdv(Integer medecinId, LocalDateTime dateRdv);

}

