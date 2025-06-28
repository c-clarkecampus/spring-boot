package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private StudentService stuService;
    @Autowired
    private GreetingService greetingService;
//    private final String appName;

    //Constructor dependency injection
    public GreetingController(GreetingService greetingService, StudentService studentService) {
        this.greetingService = greetingService;
        this.stuService = studentService;
    }

    @GetMapping("/greet")
    public String greet() {
        System.out.println(greetingService.greet());
        return greetingService.greet();
    }

}
