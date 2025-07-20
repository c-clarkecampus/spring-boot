package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.modal.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceNew {

    private StudentRepository studentRepository;   //Step 01

    public StudentServiceNew(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;  //Step 02
    }

    public Student saveStudent(StudentDTO student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        newStudent.setGrade(student.getGrade());
        Student savedStudent = studentRepository.save(newStudent);
        return savedStudent;
    }

}
