package com.altimetrik.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonFilter("DynamicFilter")
public class CustomDynamicBean {

    private String f1;

    private String f2;

    private String f3;

}
