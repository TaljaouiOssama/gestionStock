package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.AddressDto;
import com.ossama.gestionstock.dto.EntrepriseDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Entreprise;
import com.ossama.gestionstock.repository.EntrepriseRepository;
import com.ossama.gestionstock.service.EntrepriseService;
import com.ossama.gestionstock.validator.EtrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto addEntreprise(EntrepriseDto entrepriseDto) {
        List<String> errors=EtrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error(" add: EntrepriseDto is not valid",entrepriseDto);
            throw new InvalidEntityException("EntrepriseDto is not valid", ErrorsCode.Entreprise_Not_Valid,errors);
        }

        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEntity(entrepriseDto)
                ));
    }

    @Override
    public EntrepriseDto getEntrepriseById(Integer id) {
        if(id==null){
            log.error("get: entreprise id is NULL");
            return null;
        }
        return entrepriseRepository.findById(id)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Entreprise with id "+id+" Not found",ErrorsCode.Entreprise_Not_Found));
    }

    @Override
    public EntrepriseDto getEntrepriseByCode(String code) {
        if(code==null){
            log.error("get: entreprise code is null");
            return null;
        }
        return entrepriseRepository.findEntrepriseByCode(code).map(EntrepriseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Entreprise with code "+code+" Not found",ErrorsCode.Entreprise_Not_Found));
    }

    @Override
    public List<EntrepriseDto> getAllEntreprise() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto updateEntreprise(Integer id, EntrepriseDto entrepriseDto) {
        if(id==null){
            log.error("update: entreprise id is NULL");
            return null;
        }
        List<String> errors=EtrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error(" update: EntrepriseDto is not valid",entrepriseDto);
            throw new InvalidEntityException("EntrepriseDto is not valid", ErrorsCode.Entreprise_Not_Valid,errors);
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(id);
        if(!entreprise.isPresent()) {
            new EntityNotFoundException("Entreprise with id " + id + " Not found", ErrorsCode.Entreprise_Not_Found);
        }
        entreprise.get().setWebsite(entrepriseDto.getWebsite());
        entreprise.get().setPhone(entrepriseDto.getPhone());
        entreprise.get().setEmail(entrepriseDto.getEmail());
        entreprise.get().setAddress(AddressDto.toEntity(entrepriseDto.getAddress()));
        entreprise.get().setDescription(entrepriseDto.getDescription());
        entreprise.get().setName(entrepriseDto.getName());
        entreprise.get().setTaxCode(entrepriseDto.getTaxCode());
        entrepriseRepository.save(entreprise.get());
        return entrepriseRepository.findById(id)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Entreprise with id " + id + " Not found", ErrorsCode.Entreprise_Not_Found)
        );

    }

    @Override
    public EntrepriseDto deleteEntreprise(Integer id) {
        if(id==null){
            log.error("update: entreprise id is NULL");
            return null;
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(id);
        if(!entreprise.isPresent()) {
            new EntityNotFoundException("Entreprise with id " + id + " Not found", ErrorsCode.Entreprise_Not_Found);
        }
        entrepriseRepository.deleteById(id);
        return  entreprise.map(EntrepriseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Entreprise with id " + id + " Not found", ErrorsCode.Entreprise_Not_Found)
                );

    }
}
