package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Integer, ClientDto>{
}
