package com.consumoApi.controller;

import com.consumoApi.entities.Users;
import com.consumoApi.service.UsersServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsersController {
    private UsersServices usersServices;

    public UsersController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    @PostMapping
    public void saveUser(@RequestBody Users users){
        usersServices.saveUser(users);
    }

    @GetMapping
    public List<Users> searchAllUsers(){
        return usersServices.searchByName();
    }

    @GetMapping("{id}")
    public Users searchById(@PathVariable Integer id){
        return usersServices.searchById(id);
    }

}
