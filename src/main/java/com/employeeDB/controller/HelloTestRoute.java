package com.employeeDB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloTestRoute {
    @GetMapping
    public String hello(){
        return "Hello There!";
    }

}
