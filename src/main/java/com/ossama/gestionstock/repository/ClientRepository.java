package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer>{
    Optional<Client> findClientByCode(String code);
}
