package com.example.demo.controller;

import com.example.demo.modal.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {



    private StudentService stuService;

    //SETTER DEPENDENCY INJECTION

    @Autowired
    public void setStudentService(StudentService studentService){
        this.stuService=studentService;
    }

    //CRUD implement
    // GET , POST, PUT, DELETE

    @GetMapping("/getList")
    public List<Student> getStudentList() {
        return stuService.getStudentList();
    }

    @PostMapping("/addStudent")
    public Student saveStudent(@RequestBody Student student) {
        return stuService.saveStudent(student);
    }

    //We are just updating student name
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestParam(value = "name") String studentName,
                                 @RequestParam(value = "age") Integer age) {
        return stuService.updateStudent(id, studentName, age);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        return stuService.deleteStudent(id);
    }

    @GetMapping()
    public List<Student> getByName(@RequestParam (value = "name") String name){
        return stuService.getByName(name);
    }

    @GetMapping("/between")
    public List<Student> findAgeBetween(@RequestParam (value = "min") Integer min , @RequestParam (value = "max") Integer max){
        return stuService.findByAgeBetween(min,max);
    }

    @GetMapping("/less-than/{age}")
    public List<Student> LessThanAge(@PathVariable Integer age){
        return stuService.findAgeLessThan(age);
    }

    @GetMapping("/greater-than/{age}")
    public List<Student> greeterThan (@PathVariable Integer age ){
        return stuService.getGretterThan(age);
    }

    @GetMapping("/find")
    public Student findByNameAndAge (@RequestParam (value = "name") String name , @RequestParam (value = "age") Integer age){
        return  stuService.findByNameAndAge(name,age);
    }

    @GetMapping("/findBy")
    public Student findByNameOrAge (@RequestParam (value = "name") String name ,@RequestParam (value = "age") Integer age){
        return  stuService.findByNameOrAge(name,age);
    }

    @GetMapping("/like/{name}")
    public List<Student> getByNameContaining(@PathVariable String name){
        return stuService.findByNameLike(name);
    }
}
