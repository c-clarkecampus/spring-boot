package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GamService {
   public void print(int n){
       System.out.println(n);
   for (int i = 1; i <= 10; i++) {
       System.out.println(n + "*" + i + "=" + (n*i) );

   }

}

    public int area(int width, int length) {
       int area = width * length;
       return area;

    }

    public void last(Integer num1, Integer num2) {

       Integer ekthu = num1+num2;
       Integer bedim= num1/num2;
       Integer adu = num1-num2;
       Integer guna = num1*num2;

        System.out.println(ekthu);
        System.out.println(bedim);
        System.out.println(adu);
        System.out.println(guna);

    }
}
