package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberAPI {

    private final MemberService memberService;


    @PostMapping("/api/test/h")
    public void createMember(@RequestBody MemberRequestDTO requestDTO) {
        memberService.createMember(requestDTO);
    }
}
