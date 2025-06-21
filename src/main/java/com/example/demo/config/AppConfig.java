package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName(){
        System.out.println("Inside app config");
        return "Hotel Booking System";
    }
}
