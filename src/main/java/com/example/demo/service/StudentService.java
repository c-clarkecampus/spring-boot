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

    public StudentService (StudentRepository studentRepository ) {
        this.studentRepository = studentRepository;
    }


    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public String saveStudent(Student student) {
        Student  savedStudent = studentRepository.save(student);
        System.out.println(savedStudent.getId());
        return "Student saved successfully ";
    }

    public Student updateStudent(Integer id, String studentName) {
        Optional<Student> oldStudent = studentRepository.findById(id);
        if (oldStudent.isPresent()) {
            oldStudent.get().setName(studentName);
            Student updatedStudent = studentRepository.save(oldStudent.get());
            return updatedStudent;
        } else {
            throw new RuntimeException("Not found");
        }
    }

    public String deleteStudent(Integer id) {
//        List<Student> filteredList = studentList.stream().filter(stu -> stu.getId() == id).toList();
//        if (filteredList.isEmpty()) {
//            return "User not available";
//        }
//        studentList = studentList.stream().filter(stu -> stu.getId() != id).toList();
//        Student student = new Student();
//        student.setId(id);
//        studentRepository.delete(student);
        studentRepository.deleteById(id);
        return "Student deleted";
    }


    public Student findStudentByHisName(String name) {

        List<Student> studentList = studentRepository.findByAgeBetween(10,20);
        for(Student stu: studentList) {
            System.out.println(stu.getName());
        }
        return studentRepository.findByNameIgnoreCase(name);
    }
}
