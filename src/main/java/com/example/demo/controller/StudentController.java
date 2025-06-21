package com.example.demo.controller;

import com.example.demo.modal.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    List<Student> studentList = new ArrayList<>();

    //CRUD implement
    // GET , POST, PUT, DELETE

    @GetMapping("/getList")
    public List<Student> getStudentList() {
        return studentList;
    }

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student) {
        studentList.add(student);
        return "Student save success";
    }

    //We are just updating student name
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestParam(value = "id") Integer id,
                                 @RequestParam(value = "name") String studentName) {

        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == id).toList();
        filteredList.get(0).setName(studentName);
        return filteredList.get(0);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentList = studentList.stream().filter(stu -> stu.getId() != id).toList();
        return "Student deleted";
    }




}
