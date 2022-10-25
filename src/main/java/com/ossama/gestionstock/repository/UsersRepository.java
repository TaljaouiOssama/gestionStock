package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findUsersByCode(String code);
}
