package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.AddressDto;
import com.ossama.gestionstock.dto.UsersDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Entreprise;
import com.ossama.gestionstock.model.Roles;
import com.ossama.gestionstock.model.Users;
import com.ossama.gestionstock.repository.EntrepriseRepository;
import com.ossama.gestionstock.repository.RolesRepository;
import com.ossama.gestionstock.repository.UsersRepository;
import com.ossama.gestionstock.service.UsersService;
import com.ossama.gestionstock.validator.UsersValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;
    EntrepriseRepository entrepriseRepository;
    RolesRepository rolesRepository;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository,EntrepriseRepository entrepriseRepository,RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.entrepriseRepository=entrepriseRepository;
        this.rolesRepository=rolesRepository;
    }
    @Transactional
    @Override
    public UsersDto addUsers(UsersDto usersDto) {
        List<String> errors= UsersValidator.validate(usersDto);
        if(!errors.isEmpty()){
            log.error("create: usersDto is not valid",usersDto);
            throw new InvalidEntityException("usersDto is not valid",ErrorsCode.Users_Not_Valid,errors);
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(usersDto.getEntreprise().getId());
        if(!entreprise.isPresent())
        {
            log.error("Entreprise Not present with id"+usersDto.getEntreprise().getId());
            throw new EntityNotFoundException("Entreprise Not found with id"+usersDto.getEntreprise().getId(),ErrorsCode.Entreprise_Not_Found);
        }
        usersDto.getRolesList().stream().forEach(role->{
            Optional<Roles> roles= rolesRepository.findById(role.getId());
            if(!roles.isPresent()){
                log.error("Role Not Present with Id"+role.getId());
                throw new EntityNotFoundException("Role Not Present with Id"+role.getId(),ErrorsCode.Roles_Not_Found);

            }
        } );
        entreprise.get().getUsersList().add(UsersDto.toEntity(usersDto));
        entrepriseRepository.save(entreprise.get());
        return UsersDto.fromEntity(
                usersRepository.save(UsersDto.toEntity(usersDto))
        );
    }

    @Override
    public UsersDto getUsersById(Integer id) {
        if(id==null){
            log.error("get: UsersId is NULL");
            return null;
        }
        return usersRepository.findById(id).map(UsersDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("User with id "+id+" NotFound",ErrorsCode.Users_Not_Found));
    }

    @Override
    public UsersDto getUsersByCode(String code) {
        if(code==null){
            log.error("get: UsersCode is NULL");
            return null;
        }
        return usersRepository.findUsersByCode(code).map(UsersDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("User with code "+code+" NotFound",ErrorsCode.Users_Not_Found));

    }

    @Override
    public List<UsersDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(UsersDto::fromEntity)
                .collect(Collectors.toList());

    }
    @Transactional
    @Override
    public UsersDto updateUsers(Integer id, UsersDto usersDto) {
        List<String> errors= UsersValidator.validate(usersDto);
        if(!errors.isEmpty()){
            log.error("update: usersDto is not valid",usersDto);
            throw new InvalidEntityException("usersDto is not valid",ErrorsCode.Users_Not_Valid,errors);
        }
        if(id==null){
            log.error("get: UsersId is NULL");
            return null;
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(usersDto.getEntreprise().getId());
        if(!entreprise.isPresent())
        {
            log.error("Entreprise Not present with id"+usersDto.getEntreprise().getId());
            throw new EntityNotFoundException("Entreprise Not found with id"+usersDto.getEntreprise().getId(),ErrorsCode.Entreprise_Not_Found);
        }
        usersDto.getRolesList().stream().forEach(role->{
            Optional<Roles> roles= rolesRepository.findById(role.getId());
            if(!roles.isPresent()){
                log.error("Role Not Present with Id"+role.getId());
                throw new EntityNotFoundException("Role Not Present with Id"+role.getId(),ErrorsCode.Roles_Not_Found);

            }
        } );
        Optional<Users> users=usersRepository.findById(id);
        if(!users.isPresent()){
            throw new EntityNotFoundException("User with id "+id+" NotFound",ErrorsCode.Users_Not_Found);
        }
        entreprise.get().getUsersList().remove(users.get());
        entreprise.get().getUsersList().add(UsersDto.toEntity(usersDto));
        entrepriseRepository.save(entreprise.get());
        users.get().setPhone(usersDto.getPhone());
        users.get().setFirstName(usersDto.getFirstName());
        users.get().setLastName(usersDto.getLastName());
        users.get().setPicture(usersDto.getPicture());
        users.get().setPicture(usersDto.getPicture());
        users.get().setAddress(AddressDto.toEntity(usersDto.getAddress()));
        usersRepository.save(users.get());
        return usersRepository.findById(id).map(UsersDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("User with id "+id+" NotFound",ErrorsCode.Users_Not_Found));


    }
    @Transactional
    @Override
    public UsersDto deleteUsers(Integer id) {

        if(id==null){
            log.error("get: UsersId is NULL");
            return null;
        }

        Optional<Users> users=usersRepository.findById(id);
        if(!users.isPresent()){
            throw new EntityNotFoundException("User with id "+id+" NotFound",ErrorsCode.Users_Not_Found);
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(users.get().getEntreprise().getId());
        entreprise.get().getUsersList().remove(users);
        entrepriseRepository.save(entreprise.get());
        usersRepository.deleteById(id);
        return UsersDto.fromEntity(users.get());

    }
}
