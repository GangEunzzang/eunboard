package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.QuestionBoardDTO;
import com.example.eunboard.domain.dto.ReportBoardDTO;
import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.QuestionBoard;
import com.example.eunboard.service.MemberService;
import com.example.eunboard.service.QuestionBoardService;
import com.example.eunboard.service.ReportBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@ResponseBody
@RequiredArgsConstructor
@RestController
public class ReportController {


    private final ReportBoardService reportBoardService;

    private final QuestionBoardService questionBoardService;

    private final MemberService memberService;

    @GetMapping("/ReportBoard")
    public String createReportForm() {
        //model.addAttribute("memberForm", new MemberForm());
        return "/member/new API call : ok";
    }

    @PostMapping("/ReportBoard/new")
    public String createReport(@RequestBody HashMap<String, Object> param) {
        ReportBoardDTO dto =new ReportBoardDTO();
        dto.setWriterStudentId(param.get("writerStudentId").toString());
        dto.setWriterEmail(param.get("writerEmail").toString());
        dto.setReportStudentId(param.get("reportStudentId").toString());
        //dto.setTitle(".");
        dto.setContent(param.get("content").toString());

        reportBoardService.createReportBoard(dto);

        return "ok";
    }

    @GetMapping("/QuestionBoard")
    public ResponseEntity<?> createQuestionForm(@AuthenticationPrincipal long memberId ) {
        MemberResponseDTO member= memberService.select(memberId);
        List<QuestionBoard> Boards = questionBoardService.findByEmail(member.getEmail());
        return ResponseEntity.ok().body(Boards);
    }

    @PostMapping("/QuestionBoard/new")
    public String createQuestion(@AuthenticationPrincipal long memberId,
                                 @RequestBody QuestionBoardDTO requestDTO) {
        /*QuestionBoardDTO dto =new QuestionBoardDTO();
        dto.setWriterStudentId(param.get("writerStudentId").toString());
        dto.setWriterEmail(param.get("writerEmail").toString());
        //reportDTO.setReportStudentId(".");
        dto.setTitle(param.get("title").toString());
        dto.setContent(param.get("content").toString());*/

        questionBoardService.createQuestionBoard(requestDTO);

        return "save ok";
    }
}
