package com.board.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePostingRequest {

    private long id;
    private String title;
    private String content;
    private String writer;
}
