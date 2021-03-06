package com.altimetrik.restfulwebservices.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @ApiModelProperty(notes = "Name should have atleast 2 characters", example = "BBB")
    private String name;

    @Past(message = "birthday should not be future")
    @ApiModelProperty(notes = "Birthday should be past")
    private Date birthDate;

    @ApiModelProperty(notes = "list of posts")
    private List<Post> posts;
}
