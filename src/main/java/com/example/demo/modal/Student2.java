package com.example.demo.modal;

import jakarta.persistence.*;

@Entity
@Table (name = "student2")
public class Student2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String grade;


    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
