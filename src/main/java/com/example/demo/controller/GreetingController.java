package com.example.demo.controller;

import com.example.demo.modal.AppConfig;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.GreetingService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${server.port}")
    private int port;


    private final StudentService stuService;
    private final GreetingService greetingService;

    //Constructor dependency injection
    public GreetingController (StudentService studentService, GreetingService greetingService) {
        this.stuService = studentService;
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet() {
//        AppConfig appConfig = new AppConfig();
//        System.out.println(appConfig.getPort());
        System.out.println(port);
//        System.out.println(this.appName);
        return greetingService.greet();
    }

}
