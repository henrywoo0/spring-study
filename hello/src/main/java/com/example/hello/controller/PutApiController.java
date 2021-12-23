package com.example.hello.controller;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{id}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable Long id){
        System.out.println(id);
        return requestDto;
    }

}
