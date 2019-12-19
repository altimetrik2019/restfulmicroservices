package com.altimetrik.restfulwebservices.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer id;

    @ApiModelProperty(notes = "Description of the post", example = "BBB")
    private String description;

}
