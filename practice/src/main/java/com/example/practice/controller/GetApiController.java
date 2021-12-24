package com.example.practice.controller;

import com.example.practice.dto.User;
import com.example.practice.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get")
public class GetApiController {

    @GetMapping("/user")
    public User getUser() {
        var user = new User();
        user.setName("steve");
        user.setAge(20);
        user.setAddress("America");
        return user;
    }

    @GetMapping("/user/{id}")
    public String getUser02(@PathVariable String id) {
        return id;
    }

    @GetMapping("/query")
    public String queryParam(@RequestParam String name) {
        return name;
    }

    @GetMapping("/query2")
    public UserRequest queryParam(UserRequest userRequest) {
        return userRequest;
    }

}
