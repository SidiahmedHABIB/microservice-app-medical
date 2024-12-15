package com.rdvservice.client;

import com.rdvservice.model.Medecin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MEDECIN-SERVICE")
public interface MedecinRestClient {
    @GetMapping("/api/medecin/{id}")
    Medecin getMedecinById(@PathVariable("id") int id);
}
