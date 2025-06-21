package com.example.demo.service;

import com.example.demo.modal.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public String saveStudent(Student student) {
        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == student.getId()).toList();
        if (!filteredList.isEmpty()) {
            return "Student already exist for this Id" + student.getId();
        }
        studentList.add(student);
        return "Student saved successfully ";
    }

    public Student updateStudent(Integer id, String studentName) {
        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == id).toList();
        if (filteredList.isEmpty()) {
            return new Student();
        }
        filteredList.get(0).setName(studentName);
        return filteredList.get(0);
    }

    public String deleteStudent(Integer id) {
        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == id).toList();
        if (filteredList.isEmpty()) {
            return "User not available";
        }
        studentList = studentList.stream().filter(stu -> stu.getId() != id).toList();
        return "Student deleted";
    }



}
