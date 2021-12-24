package com.example.practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delete")
public class DeleteApiController {

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, @RequestParam String name) {
        System.out.println(id);
        System.out.println(name);
    }

}
