package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private final GreetingService greetingService;
    private final String appName;

    //Constructor dependency injection
    public GreetingController(GreetingService greetingService, String appName) {
        this.greetingService = greetingService;
        this.appName = appName;
    }

    @GetMapping("/greet")
    public String greet() {
//        System.out.println(this.appName);
        return greetingService.greet();
    }

}
