package com.altimetrik.restfulwebservices.config;

import java.util.List;

import org.mapstruct.Mapper;

import com.altimetrik.restfulwebservices.entity.PostEntity;
import com.altimetrik.restfulwebservices.entity.UserEntity;
import com.altimetrik.restfulwebservices.model.Post;
import com.altimetrik.restfulwebservices.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(User user);

    User fromEntity(UserEntity user);

    List<User> fromEntityList(List<UserEntity> user);
    
    PostEntity toPOEntity(Post post);

    Post fromPOEntity(PostEntity post);

    List<Post> fromPOEntityList(List<PostEntity> post);

}
