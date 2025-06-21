package com.example.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/api/healthCheck")
    public String checkHealth() {
        return "Application is running";
    }

    @GetMapping("/api/status/check")
    public String checkStatus() {
        return "Status is alive";
    }
}
