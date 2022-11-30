package com.board.global.security.handler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        String errorMessage;

        if (e instanceof BadCredentialsException || e instanceof InternalAuthenticationServiceException){
            errorMessage = "아이디 또는 비밀번호가 옳지 않습니다.";
        } else if (e instanceof UsernameNotFoundException){
            errorMessage = "존재하지 않는 아이디 입니다.";
        } else {
            errorMessage = "알 수 없는 이유로 로그인이 안되고 있습니다.";
        }

        errorMessage = URLEncoder.encode(errorMessage,"UTF-8");
        setDefaultFailureUrl("/user/login?error=true&exception=" + errorMessage);
        super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
    }
}
