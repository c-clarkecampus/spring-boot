package com.example.demo.modal;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bank {
    @Autowired
    private Branch branch;

    public void print(){
        branch.print();
        ApplicationContext.class.getClasses();
    }

    //constructor injection
//    public Bank(Branch branch) {
//        this.branch = branch;
//    }

    //Setter injection
//    public void setBranch(Branch branch) {
//        this.branch = branch;
//    }
}
