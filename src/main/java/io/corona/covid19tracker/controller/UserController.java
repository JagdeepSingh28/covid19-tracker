package io.corona.covid19tracker.controller;

import io.corona.covid19tracker.models.Users;
import io.corona.covid19tracker.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    @PostMapping(value = "/save")
    public List<Users> saveUser(@RequestBody final Users users){
        usersRepository.save(users);
        return usersRepository.findAll();
    }
}
