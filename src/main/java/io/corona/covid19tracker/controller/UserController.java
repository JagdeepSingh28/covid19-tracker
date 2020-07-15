package io.corona.covid19tracker.controller;

import io.corona.covid19tracker.models.Users;
import io.corona.covid19tracker.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequestMapping(value = "/rest/users")
@RestController
public class UserController {

//    @Autowired
//    UsersRepository usersRepository;

//    @GetMapping(value = "/all")
//    public List<Users> getAll(){
//        return usersRepository.findAll();
//    }
//
//    @PostMapping(value = "/save")
//    public List<Users> saveUser(@RequestBody final Users users){
//        usersRepository.save(users);
//        return usersRepository.findAll();
//    }

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
