package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;

@RestController
public class GreetingController {

    @Value("${server-port}")
    private int port;

    @Value("${dbaddress}")
    private String dbAddress;

    private final StudentService studentService;
    private final GreetingService greetingService;

//    Constructor dependency injection
    public GreetingController (StudentService studentService, GreetingService greetingService) {
        this.studentService = studentService;
        this.greetingService = greetingService;
    }

    //Constructor dependency injection
//    public GreetingController(GreetingService greetingService, String appName) {
//        this.greetingService = greetingService;
//        this.appName = appName;
//    }

    @GetMapping("/greet")
    public String greet() {
        System.out.println(port);
        System.out.println(dbAddress);
//        System.out.println(this.appName);
        return greetingService.greet();
    }

}
