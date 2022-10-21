package com.ossama.gestionstock.repository;
import com.ossama.gestionstock.dto.UsersDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Integer, UsersDto> {
}
