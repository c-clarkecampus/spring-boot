package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.modal.Student;
import com.example.demo.service.StudentServiceNew;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class GameController {

    private StudentServiceNew studentService; //Step one


    public GameController(StudentServiceNew studentService) { //step two
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody StudentDTO student) {
        Student savedStudent = studentService.saveStudent(student); // step 03
        return savedStudent;
    }


}
