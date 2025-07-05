package com.example.demo.repository;

import com.example.demo.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface StudentRepository extends JpaRepository<Student , Integer> {

    List<Student> findByNameIgnoreCase(String name);
    List<Student> findByAgeBetween(Integer min , Integer max);

    List<Student> findByAgeLessThan(Integer age);

    List<Student> findByAgeGreaterThan(Integer age);

    Student findByNameAndAge(String name , Integer age);

    Student findByNameOrAge(String name , Integer age);

    List<Student> findByNameContaining(String name);


}
