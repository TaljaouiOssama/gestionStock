package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.EntrepriseApi;
import com.ossama.gestionstock.dto.EntrepriseDto;
import com.ossama.gestionstock.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseApiImpl implements EntrepriseApi {
    private EntrepriseService entrepriseService;
    @Autowired
    public EntrepriseApiImpl(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto saveEntreprise(EntrepriseDto entrepriseDto) {
        return this.entrepriseService.addEntreprise(entrepriseDto);
    }

    @Override
    public EntrepriseDto findEntrepriseById(Integer entrepriseId) {
        return this.entrepriseService.getEntrepriseById(entrepriseId);
    }

    @Override
    public EntrepriseDto findEntrepriseByCode(String entrepriseCode) {
        return this.entrepriseService.getEntrepriseByCode(entrepriseCode);
    }

    @Override
    public List<EntrepriseDto> findAllEntreprises() {
        return this.entrepriseService.getAllEntreprise();
    }

    @Override
    public EntrepriseDto deleteEntrepriseById(Integer entrepriseId) {
        return this.entrepriseService.deleteEntreprise(entrepriseId);
    }
}
