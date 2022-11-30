package com.board.service;

import com.board.domain.Posting;
import com.board.presentation.dto.request.SavePostingRequest;
import com.board.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {

    private final PostingRepository postingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPosting(SavePostingRequest request) {

        Posting posting = Posting.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writer(request.getUser())
                .build();

        postingRepository.save(posting);
    }

    @Override
    @Transactional(readOnly = true)
    public Posting getPostingById(long id) {
        return postingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 id 값입니다."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Posting> getList() {
        return postingRepository.findAllByOrderByCreatedDateDesc();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Posting viewPostingById(long id) {
        Posting posting = postingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 id 값입니다."));
        posting.increaseViewCount();
        postingRepository.save(posting);
        return posting;
    }
}
