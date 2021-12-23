package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 Class 는 REST API 처리하는 Controller
@RequestMapping("/api") // RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    // TEXT
    @GetMapping("/hello") // http://localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!";
    }

    // JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201 Created

    }
}
