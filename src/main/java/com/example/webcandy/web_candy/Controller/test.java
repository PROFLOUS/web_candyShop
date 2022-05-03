package com.example.webcandy.web_candy.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World:" + LocalDateTime.now() + LocalDate.now();
    }

    @GetMapping("/test")
    public String sayTest() {
        return "TestController:";
    }
}
