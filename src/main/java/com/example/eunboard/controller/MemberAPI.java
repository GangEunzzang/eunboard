package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.service.MemberService;
import com.example.eunboard.service.MemberTimetableService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberAPI {

    private final MemberService memberService;

    private final MemberTimetableService memberTimetableService;

    @GetMapping
    public MemberResponseDTO selectMember(@AuthenticationPrincipal long memberId) {
        return memberService.select(memberId);
    }

    @ResponseBody
    @PostMapping("/area")
    public void updateMemberArea(@AuthenticationPrincipal long memberId,
            @RequestBody MemberRequestDTO requestDTO) {
        memberService.updateMemberArea(memberId, requestDTO);
    }

    @ResponseBody
    @PostMapping("/new")
    public void updateMember(@AuthenticationPrincipal long memberId,
            @RequestPart("image") MultipartFile multipartFile,
            @RequestPart("userData") MemberRequestDTO requestDTO) {

        System.out.println(memberId);
        System.out.println(requestDTO.toString());
        System.out.println(multipartFile.getOriginalFilename());

        memberTimetableService.saveAll(memberId, requestDTO.getMemberTimeTable());
        memberService.updatMember(memberId, requestDTO);
    }
}
