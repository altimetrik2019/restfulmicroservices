package com.altimetrik.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = { "f2" })
public class CustomBean {

    private String f1;

    private String f2;

    @JsonIgnore
    private String f3;

}
