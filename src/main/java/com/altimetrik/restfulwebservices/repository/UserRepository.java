package com.altimetrik.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.altimetrik.restfulwebservices.model.User;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "A", new Date()));
        users.add(new User(2, "B", new Date()));
        users.add(new User(3, "C", new Date()));
    }
    
    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
    }

}