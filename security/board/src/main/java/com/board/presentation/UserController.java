package com.board.presentation;

import com.board.presentation.dto.request.UserLoginRequest;
import com.board.presentation.dto.request.UserRegisterRequest;
import com.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "user/register";
    }

    @PostMapping("/register")
    public String doRegister(
            @RequestParam String id,
            @RequestParam String password,
            @RequestParam String name
    ) {
        UserRegisterRequest request = new UserRegisterRequest(id, password, name);
        userService.register(request);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLoginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception,
            Model model
    ) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "user/login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String id,
            @RequestParam String password
            ) {
        UserLoginRequest request = new UserLoginRequest(id, password);
        userService.login(request);
        return "posting/list";
    }
}
