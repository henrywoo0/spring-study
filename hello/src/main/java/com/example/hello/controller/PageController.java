package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // ResponseEntity
    // 보통 RestController가 아닌 곳에서는 아래처럼 하지 않음

    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        return user;
    }


}
