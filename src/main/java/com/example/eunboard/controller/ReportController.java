package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.TicketDTO;
import com.example.eunboard.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReportController {

    @GetMapping("/ReportBoard")
    public String createForm() {
        //model.addAttribute("memberForm", new MemberForm());
        return "/member/new API call : ok";
    }

    @PostMapping("/ReportBoard/new")
    public String create() {

        //JsonObject userInfo = new JsonObject();
        //userInfo.addProperty("name", "건일");

        return "";
    }

    @GetMapping("/QuestionBoard")
    public String createQuestionForm() {
        return "/member/new API call : ok";
    }

    @PostMapping("/QuestionBoard/new")
    public String createQuestion() {


        return "";
    }
}
