package com.example.demo.service;

import com.example.demo.modal.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, String name, Integer age) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setAge(age);
        student.setName(name);

        return studentRepository.save(student);
    }

    public String deleteStudent(Integer id) {
       studentRepository.deleteById(id);
        return "Student deleted";
    }

    public List<Student> getByName(String name){
       return studentRepository.findByNameIgnoreCase(name);
    }


    public List<Student> findByAgeBetween(Integer min, Integer max) {
        return  studentRepository.findByAgeBetween(min,max);
    }


    public List<Student> findAgeLessThan(Integer age) {
        return studentRepository.findByAgeLessThan(age);
    }

    public List<Student> getGretterThan(Integer age) {
        return  studentRepository.findByAgeGreaterThan(age);
    }

    public Student findByNameAndAge(String name, Integer age) {
        return studentRepository.findByNameAndAge(name,age);
    }

    public Student findByNameOrAge(String name, Integer age) {
        return  studentRepository.findByNameOrAge(name,age);
    }

    public List<Student> findByNameLike(String name) {
        return studentRepository.findByNameContaining(name);
    }
}
