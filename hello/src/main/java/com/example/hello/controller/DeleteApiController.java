package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {

        // delete -> 리소스 삭제
        // 리소스 삭제이기 때문에 이미 리스소가 없는 상태이더라도 200 OK
        // 멱등성 유지

        System.out.println(userId);
        System.out.println(account);

    }

}
