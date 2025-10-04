package com.consumoApi.controller;

import com.consumoApi.entities.Users;
import com.consumoApi.repository.UsersRepository;
import com.consumoApi.service.UsersServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UsersController {
    private UsersServices usersServices;
    private UsersRepository usersRepository;

    public UsersController(UsersServices usersServices, UsersRepository usersRepository) {
        this.usersServices = usersServices;
        this.usersRepository = usersRepository;
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

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id){
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody Users userDetails) {
        Optional<Users> optionalUser = usersRepository.findById(id);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setSenha(userDetails.getSenha());
            usersRepository.save(user);

            return ResponseEntity.ok("Usuário com ID " + id + " atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com ID " + id + " não encontrado.");
        }
    }


}
