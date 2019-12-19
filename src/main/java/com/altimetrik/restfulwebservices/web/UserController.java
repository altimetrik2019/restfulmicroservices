package com.altimetrik.restfulwebservices.web;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.altimetrik.restfulwebservices.exception.UserNotFoundException;
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
    public Resource<User> retriveUser(@PathVariable int id) {
        User u = userRepository.findOne(id);
        if (u == null) {
            throw new UserNotFoundException("id - " + id);
        }
        // HATEOAS
        Resource<User> r = new Resource<>(u);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
        r.add(linkTo.withRel("all-users"));
        return r;
    }

    // POST
    // create a user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    // DELETE
    // delete a user
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User u = userRepository.deleteById(id);
        if (u == null) {
            throw new UserNotFoundException("id - " + id);
        }
    }

}
