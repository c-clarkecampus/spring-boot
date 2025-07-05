package com.example.demo.controller;

import com.example.demo.service.GamService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/area")
    public int getArea(@RequestParam (value = "width")int width , @RequestParam (value="length")int length ){
       return service.area(width,length);
    }


}
