package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.UsersDto;

import java.util.List;

public interface UsersService {
    UsersDto addUsers(UsersDto usersDto);
    UsersDto getUsersById(Integer id);
    UsersDto getUsersByCode(String code);
    List<UsersDto> getAllUsers();
    UsersDto updateUsers(Integer id,UsersDto usersDto);
    UsersDto deleteUsers(Integer id);
}
