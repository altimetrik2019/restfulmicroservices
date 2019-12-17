package com.altimetrik.restfulwebservices.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.restfulwebservices.model.User;
import com.altimetrik.restfulwebservices.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    // GET
    // retrieve Users
    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return userRepository.findAll();
    }
    
    
    // GET
    // retrieve User By Id
    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id) {
        return null;
    }
}
