package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.ENTREPRISE_API;

public interface EntrepriseApi {
    @PostMapping(value = ENTREPRISE_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto saveEntreprise(@RequestBody EntrepriseDto entrepriseDto);
    @GetMapping(value = ENTREPRISE_API+"/{entrepriseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseById(@PathVariable Integer entrepriseId);
    @GetMapping(value = ENTREPRISE_API+"/{entrepriseCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseByCode(@PathVariable String entrepriseCode);
    @GetMapping(value = ENTREPRISE_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAllEntreprises();
    @DeleteMapping(value=ENTREPRISE_API+"/delete/{entrepriseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto deleteEntrepriseById(@PathVariable Integer entrepriseId);
}
