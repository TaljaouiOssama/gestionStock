package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.UsersApi;
import com.ossama.gestionstock.dto.SalesDto;
import com.ossama.gestionstock.dto.UsersDto;
import com.ossama.gestionstock.service.UsersService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UsersApiImpl implements UsersApi {
    private UsersService usersService;

    public UsersApiImpl(UsersService usersService) {
        this.usersService = usersService;
    }


    @Override
    public UsersDto saveUsers(UsersDto usersDto) {
        return usersService.addUsers(usersDto);
    }

    @Override
    public UsersDto findUsersById(Integer usersId) {
        return usersService.getUsersById(usersId);
    }

    @Override
    public UsersDto findUsersByCode(String usersCode) {
        return usersService.getUsersByCode(usersCode);
    }

    @Override
    public List<UsersDto> findAllUsers() {
        return usersService.getAllUsers();
    }

    @Override
    public UsersDto deleteUsersById(Integer usersId) {
        return usersService.deleteUsers(usersId);
    }
}
