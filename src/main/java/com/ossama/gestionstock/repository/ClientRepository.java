package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer>{
}
