package com.board.service;

import com.board.domain.Posting;
import com.board.presentation.dto.request.SavePostingRequest;
import com.board.presentation.dto.request.UpdatePostingRequest;

import java.util.List;

public interface PostingService {

    /**
     * 포스팅 생성 메서드
     * @param request 글 제목, 내용, 작성자를 담은 DTO 입니다.
     */
    void createPosting(SavePostingRequest request);

    /**
     * id 값으로 포스팅 불러오기 메서드
     * @param id 포스팅의 PK 값입니다.
     * @return Posting 을 리턴합니다.
     */
    Posting getPostingById(long id);

    /**
     * 포스팅 리스트 불러오기 메서드
     * @return Posting List 를 리턴합니다.
     */
    List<Posting> getList();

    /**
     * 조회수를 올리는 포스팅 불러오기 메서드
     * @param id 포스팅의 PK 값입니다.
     * @return Posting 을 리턴합니다.
     */
    Posting viewPostingById(long id);
}
