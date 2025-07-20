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

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {

        return studentRepository.findAll();
    }

    public String saveStudent(Student student) {
//        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == student.getId()).toList();
//        if (!filteredList.isEmpty()) {
//            return "Student already exist for this Id" + student.getId();
//        }
//        studentList.add(student);
        studentRepository.save(student);
        return "Student saved successfully ";
    }

    public Student updateStudent(Integer id, String studentName) {
//        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == id).toList();
//        if (filteredList.isEmpty()) {
//            return new Student();
//        }
//        filteredList.get(0).setName(studentName);
//        return filteredList.get(0);
        Optional<Student> oldStudent = studentRepository.findById(id);
        if (oldStudent.isPresent()) {
            oldStudent.get().setName(studentName);
            Student updatedStudent = studentRepository.save(oldStudent.get());
            return updatedStudent;
        } else {
            throw new RuntimeException("Not Found");
        }
    }

    public String deleteStudent(Integer id) {
        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == id).toList();
        if (filteredList.isEmpty()) {
            return "User not available";
        }
        studentList = studentList.stream().filter(stu -> stu.getId() != id).toList();
        return "Student deleted";
    }
    public Student findByName(String name){
        return studentRepository.findByNameIgnoreCase(name);
    }



}
