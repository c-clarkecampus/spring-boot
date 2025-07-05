package com.example.demo.controller;

import com.example.demo.service.GamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GameController {

    private GamService service;
    public GameController(GamService service){
        this.service=service;
    }
    @GetMapping("/number/{number}")
    public void getNumber(@PathVariable int number){
        service.print(number);
    }
}
