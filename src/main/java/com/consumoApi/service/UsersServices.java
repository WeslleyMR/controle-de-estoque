package com.consumoApi.service;

import com.consumoApi.entities.Users;
import com.consumoApi.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServices {
    private UsersRepository usersRepository;

    public UsersServices(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void saveUser(Users users){
        usersRepository.save(users);
    }

    public Users searchById(Integer id){
        return usersRepository.findById(id).orElse(null);
    }

    public List<Users> searchByName(){
        return usersRepository.findAll();
    }

    public void deleteUsers(Integer id){
        usersRepository.deleteById(id);
    }

    public Users updateUsers(Integer id, Users users){
        Users existingUser = usersRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setName(users.getName());
            return usersRepository.save(existingUser);
        }
        return null;
    }
}
