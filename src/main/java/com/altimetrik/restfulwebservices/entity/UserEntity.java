package com.altimetrik.restfulwebservices.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Entity(name = "users")
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @ApiModelProperty(notes = "Name should have atleast 2 characters", example = "BBB")
    @Column(name = "name")
    private String name;

    @Past(message = "birthday should not be future")
    @ApiModelProperty(notes = "Birthday should be past")
    @Column(name = "birthdate")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts;
}
