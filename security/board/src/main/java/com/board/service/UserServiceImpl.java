package com.board.service;

import com.board.domain.User;
import com.board.presentation.dto.request.UserLoginRequest;
import com.board.presentation.dto.request.UserRegisterRequest;
import com.board.repository.UserRepository;
import com.board.security.principal.PrincipalDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(UserRegisterRequest request) {
        if (userRepository.existsById(request.getId())) {
            throw new IllegalArgumentException("이미 존재하는 id 입니다.");
        }
        User user = User.builder()
                .id(request.getId())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public void login(UserLoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getId(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // PrincipalDetail principalDetail = (PrincipalDetail) authentication.getPrincipal();
    }
}
