package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.service.MemberService;
import com.example.eunboard.service.MemberTimetableService;
import com.example.eunboard.util.FileUploadUtils;
import com.example.eunboard.util.MD5Generator;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
            @RequestPart(required = false, name = "image") MultipartFile multipartFile,
            @RequestPart(required = false, name = "userData") MemberRequestDTO requestDTO) {

        // FileUploadUtils.cleanDir("/image/profiles");
        if (multipartFile != null) {
            String originName = multipartFile.getOriginalFilename();
            String ext = originName.substring(originName.lastIndexOf(".") + 1);

            String newFileName = new MD5Generator(originName).toString() + "." + ext;
            FileUploadUtils.saveFile("/image/profiles/" + memberId, newFileName, multipartFile);

            memberService.updateProfileImage(memberId, newFileName);
        }

        memberTimetableService.saveAll(memberId, requestDTO.getMemberTimeTable());
        memberService.updatMember(memberId, requestDTO);
    }
}
