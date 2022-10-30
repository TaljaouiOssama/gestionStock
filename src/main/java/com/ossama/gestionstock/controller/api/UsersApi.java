package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.UsersDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.USERS_API;

public interface UsersApi {
    @PostMapping(value = USERS_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    UsersDto saveUsers(@RequestBody UsersDto usersDto);
    @GetMapping(value = USERS_API+"/{usersId}",produces = MediaType.APPLICATION_JSON_VALUE)
    UsersDto findUsersById(@PathVariable Integer usersId);
    @GetMapping(value = USERS_API+"/{usersCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    UsersDto findUsersByCode(@PathVariable String usersCode);
    @GetMapping(value = USERS_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<UsersDto> findAllUsers();
    @DeleteMapping(value = USERS_API+"/delete/{usersId}",produces = MediaType.APPLICATION_JSON_VALUE)
    UsersDto deleteUsersById(@PathVariable Integer usersId);
}
