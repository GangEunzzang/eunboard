package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.QuestionBoardDTO;
import com.example.eunboard.domain.dto.ReportBoardDTO;
import com.example.eunboard.domain.entity.QuestionBoard;
import com.example.eunboard.service.QuestionBoardService;
import com.example.eunboard.service.ReportBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@ResponseBody
@RequiredArgsConstructor
@RestController
public class ReportController {

    @Autowired
    private ReportBoardService reportBoardService;
    @Autowired
    private QuestionBoardService questionBoardService;


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
    public ResponseEntity<?> createQuestionForm(@RequestBody HashMap<String, Object> param) {
        List<QuestionBoard> Boards = questionBoardService.findByEmail(param.get("writerEmail").toString());
        return ResponseEntity.ok().body(Boards);
    }

    @PostMapping("/QuestionBoard/new")
    public String createQuestion(@RequestBody HashMap<String, Object> param) {
        QuestionBoardDTO dto =new QuestionBoardDTO();
        dto.setWriterStudentId(param.get("writerStudentId").toString());
        dto.setWriterEmail(param.get("writerEmail").toString());
        //reportDTO.setReportStudentId(".");
        dto.setTitle(param.get("title").toString());
        dto.setContent(param.get("content").toString());

        questionBoardService.createQuestionBoard(dto);

        return "save ok";
    }
}
