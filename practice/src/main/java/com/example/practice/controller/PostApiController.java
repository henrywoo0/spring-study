package com.example.practice.controller;

import com.example.practice.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostApiController {

    @PostMapping("/post")
    public User postUser(@RequestBody User user) {
        return user;
    }

    @PostMapping("/post/{id}")
    public String postUser02(@RequestBody User user, @PathVariable(name = "id") String userId) {
        return user.toString() + " " + userId;
    }

    @PostMapping("/post02")
    public ResponseEntity<User> postUser03(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
