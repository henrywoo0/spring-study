package com.board.presentation.dto.request;

import com.board.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SavePostingRequest {

    private String title;
    private String content;
    private User user;
}
