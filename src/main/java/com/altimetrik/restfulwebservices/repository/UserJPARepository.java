package com.altimetrik.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.restfulwebservices.entity.UserEntity;

@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {

}
