package com.altimetrik.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.restfulwebservices.entity.PostEntity;

@Repository
public interface PostJPARepository extends JpaRepository<PostEntity, Integer> {

}
