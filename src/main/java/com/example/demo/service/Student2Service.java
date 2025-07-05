package com.example.demo.service;

import com.example.demo.modal.Student2;
import com.example.demo.repository.Student2Repository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class Student2Service {
    private final Student2Repository student2Repository;


    public Student2Service(Student2Repository student2Repository) {
        this.student2Repository = student2Repository;
    }

    public Student2 create(Student2 student){
     return student2Repository.save(student);
    }
}
