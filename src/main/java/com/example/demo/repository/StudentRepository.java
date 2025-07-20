package com.example.demo.repository;

import com.example.demo.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //findAll
    //findById
    //save()
    //deleteById
    Student findByNameIgnoreCase(String name);
    List<Student> findByAgeBetween(Integer min);
    //LessThan
    List<String> findByAgeLessThan(Integer age);
    //GreaterThan
    List<String> findByAgeGreaterThan(Integer age);
    //And Operation
    Student findByNameAndAge(String stuName, Integer age);
    //Or Operation
    Student findByNameOrAge(String name, Integer age);
    //Like
    Student findByNameContaining(String name);

}
