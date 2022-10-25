package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto addEntreprise(EntrepriseDto entrepriseDto);
    EntrepriseDto getEntrepriseById(Integer id);
    EntrepriseDto getEntrepriseByCode(String code);
    List<EntrepriseDto> getAllEntreprise();
    EntrepriseDto updateEntreprise(Integer id,EntrepriseDto entrepriseDto);
    EntrepriseDto deleteEntreprise(Integer id);
}
