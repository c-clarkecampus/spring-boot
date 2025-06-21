package com.example.demo.controller;

import com.example.demo.modal.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

//    @Autowired
    private final StudentService stuService;

    public StudentController (StudentService studentService) {
        this.stuService = studentService;
    }

    //CRUD implement
    // GET , POST, PUT, DELETE

    @GetMapping("/getList")
    public List<Student> getStudentList() {
        return stuService.getStudentList();
    }

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student) {
        return stuService.saveStudent(student);
    }

    //We are just updating student name
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestParam(value = "id") Integer id,
                                 @RequestParam(value = "name") String studentName) {
        return stuService.updateStudent(id, studentName);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        return stuService.deleteStudent(id);
    }




}
