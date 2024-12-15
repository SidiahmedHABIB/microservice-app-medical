package com.medecinservice.service;


import com.medecinservice.entities.Medecin;

import java.util.List;

public interface IServiceMedecin {
    List<Medecin> getAllMedecins();
    Medecin getById(int id);
   }
