package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
