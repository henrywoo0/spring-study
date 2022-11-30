package com.board.service;

import com.board.presentation.dto.request.UserLoginRequest;
import com.board.presentation.dto.request.UserRegisterRequest;

public interface UserService {
    void register(UserRegisterRequest request);
    void login(UserLoginRequest request);
}
