/**
 * 
 */
package com.altimetrik.restfulwebservices.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.restfulwebservices.model.HelloWorldBean;

/**
 * @author user
 *
 */
//Controller
@RestController
public class HelloWorldController {
    // GET
    // URI - hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/path/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
