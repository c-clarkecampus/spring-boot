package com.example.demo.controller;

import com.example.demo.modal.Student2;
import com.example.demo.service.GamService;
import com.example.demo.service.Student2Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GameController {

    private GamService service;
    private Student2Service s2;
    public GameController(GamService service, Student2Service s2){
        this.service=service;
        this.s2=s2;
    }

    @GetMapping("/number/{number}")
    public void getNumber(@PathVariable int number){
        service.print(number);
    }

    @GetMapping("/area")
    public int getArea(@RequestParam (value = "width")int width , @RequestParam (value="length")int length ){
       return service.area(width,length);
    }

    @PostMapping()
    public Student2 create(@RequestBody Student2 student2){
        return s2.create(student2);
    }


    @GetMapping("numbers")
    public void numbers(
            @RequestParam (value = "first") Integer num1 ,
            @RequestParam (value = "second") Integer num2 ){
service.last(num1, num2) ;
    }


}
