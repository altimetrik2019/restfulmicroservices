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

import com.altimetrik.restfulwebservices.config.UserMapper;
import com.altimetrik.restfulwebservices.entity.PostEntity;
import com.altimetrik.restfulwebservices.entity.UserEntity;
import com.altimetrik.restfulwebservices.exception.UserNotFoundException;
import com.altimetrik.restfulwebservices.model.Post;
import com.altimetrik.restfulwebservices.model.User;
import com.altimetrik.restfulwebservices.repository.PostJPARepository;
import com.altimetrik.restfulwebservices.repository.UserJPARepository;

@RestController
public class UserJPAController {

    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private PostJPARepository postJPARepository;

    @Autowired
    private UserMapper userMapper;

    // GET
    // retrieve Users
    @GetMapping("/jpa/users")
    public List<User> retriveAllUsers() {
        return userMapper.fromEntityList(userJPARepository.findAll());
    }

    // GET
    // retrieve User By Id
    @GetMapping("/jpa/users/{id}")
    public Resource<User> retriveUser(@PathVariable int id) {
        User u = userMapper.fromEntity(userJPARepository.findById(id).orElse(null));
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
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        User savedUser = userMapper.fromEntity(userJPARepository.save(userEntity));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    // DELETE
    // delete a user
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        if (userJPARepository.existsById(id)) {
            userJPARepository.deleteById(id);
        } else {
            throw new UserNotFoundException("id - " + id);
        }
    }

    // GET
    // get all the posts of the user
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getPosts(@PathVariable int id) {
        User u = userMapper.fromEntity(userJPARepository.findById(id).orElse(null));
        if (u == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return u.getPosts();
    }

    // POST
    // post of the user
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post p) {
        UserEntity userEntity = userJPARepository.findById(id).orElse(null);
        User u = userMapper.fromEntity(userEntity);
        if (u == null) {
            throw new UserNotFoundException("id - " + id);
        }
        PostEntity postEntity = userMapper.toPOEntity(p);
        postEntity.setUser(userEntity);
        p = userMapper.fromPOEntity(postJPARepository.save(postEntity));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
