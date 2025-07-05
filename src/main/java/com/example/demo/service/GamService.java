package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GamService {
   public void print(int n){
       System.out.println(n);
   for (int i = 1; i <= 10; i++) {
       System.out.println(n + "*" + i + "=" + (n*i) );

   }

}}
