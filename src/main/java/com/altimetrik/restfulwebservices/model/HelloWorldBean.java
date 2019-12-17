package com.altimetrik.restfulwebservices.model;

import lombok.Getter;
import lombok.Setter;

public class HelloWorldBean {

    @Getter
    @Setter
    private String message;


    public HelloWorldBean(String message) {
        this.message = message;
    }

}
