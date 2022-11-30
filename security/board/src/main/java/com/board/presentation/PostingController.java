package com.board.presentation;

import com.board.domain.Posting;
import com.board.presentation.dto.request.SavePostingRequest;
import com.board.global.security.principal.PrincipalDetail;
import com.board.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @GetMapping("/write")
    public String getWritePosting() {
        return "posting/write";
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePosting(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("posting/update");
        Posting posting = postingService.getPostingById(id);
        mv.addObject("posting", posting);
        return mv;
    }

    @GetMapping("/list")
    public ModelAndView getPostingList() {
        ModelAndView mv = new ModelAndView("posting/list");
        List<Posting> list = postingService.getList();
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping("/view/{id}")
    public ModelAndView getPostingById(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("posting/view");
        Posting posting = postingService.viewPostingById(id);
        mv.addObject("posting", posting);
        return mv;
    }

    @PostMapping("/write.do")
    public String savePosting(
            @RequestParam String title,
            @RequestParam String content,
            @AuthenticationPrincipal PrincipalDetail principalDetail
            ) {
        SavePostingRequest request = new SavePostingRequest(title, content, principalDetail.getUser());
        postingService.createPosting(request);
        return "redirect:list";
    }
}
