package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.request.MemberTimetableRequestDTO;
import com.example.eunboard.domain.dto.response.BaseResponseDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.domain.dto.response.MemberTimetableResponseDTO;
import com.example.eunboard.domain.entity.Area;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.MemberTimetable;
import com.example.eunboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberAPI {

    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<?> selectMember(@AuthenticationPrincipal long memberId) {

        try {
            Member member = memberService.select(memberId);
            MemberResponseDTO responseDTO = MemberResponseDTO.toDTO(member);

            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            String error = e.getMessage();
            BaseResponseDTO<MemberResponseDTO> responseDTO = BaseResponseDTO.<MemberResponseDTO>builder().error(error)
                    .build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @ResponseBody
    @PostMapping("/member/area")
    public ResponseEntity<?> updateMemberArea(@AuthenticationPrincipal long memberId,
            @RequestBody MemberRequestDTO requestDTO) {

        try {

            final Member responseEntity = memberService.updateMemberArea(memberId,
                    MemberRequestDTO.toEntity(requestDTO));
            List<MemberTimetableResponseDTO> resTimetables = memberService.selectTimetables(responseEntity);

            final MemberResponseDTO responseMemberDTO = MemberResponseDTO.builder()
                    .email(responseEntity.getEmail())
                    .memberName(responseEntity.getMemberName())
                    .auth(responseEntity.getAuth())
                    .studentNumber(responseEntity.getStudentNumber())
                    .department(responseEntity.getDepartment())
                    .profileImage(responseEntity.getProfileImage())
                    .isMember(responseEntity.getAuth() != null ? true : false)
                    .area(responseEntity.getArea())
                    .memberTimeTable(resTimetables)
                    .build();
            return ResponseEntity.ok().body(responseMemberDTO);
        } catch (Exception e) {
            String error = e.getMessage();
            BaseResponseDTO<MemberResponseDTO> responseDTO = BaseResponseDTO.<MemberResponseDTO>builder().error(error)
                    .build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @ResponseBody
    @PostMapping("/member/new")
    public ResponseEntity<?> updateMember(@AuthenticationPrincipal long memberId,
            @RequestBody MemberRequestDTO requestDTO) {
        try {
            List<MemberTimetableRequestDTO> timeTables = requestDTO.getMemberTimeTable();

            Member member = memberService.select(memberId);

            List<MemberTimetable> timetableEntities = new ArrayList<>();
            timeTables.forEach(timeTable -> {
                MemberTimetable memberTimetableEntity = MemberTimetable.builder()
                        .member(member)
                        .dayCode(timeTable.getDayCode())
                        .build();
                timetableEntities.add(memberTimetableEntity);
            });

            Member memberEntity = Member.builder()
                    .memberId(memberId)
                    .studentNumber(requestDTO.getStudentNumber())
                    .department(requestDTO.getDepartment())
                    .memberName(requestDTO.getMemberName())
                    .phoneNumber(requestDTO.getPhoneNumber())
                    .auth(requestDTO.getAuth())
                    .area(requestDTO.getArea())
                    .memberTimeTable(timetableEntities)
                    .build();

            final Member responseEntity = memberService.updatMember(memberId, memberEntity);
            final List<MemberTimetable> saveTableList = memberService.saveMemberTimetables(memberEntity);
            final List<MemberTimetableResponseDTO> resMemberTimetables = new ArrayList<>();
            saveTableList.forEach(timeTable -> {
                MemberTimetableResponseDTO memberTimetableDTO = MemberTimetableResponseDTO.builder()
                        .dayCode(timeTable.getDayCode()).build();
                resMemberTimetables.add(memberTimetableDTO);
            });

            final MemberResponseDTO responseMemberDTO = MemberResponseDTO.builder()
                    .email(responseEntity.getEmail())
                    .memberName(responseEntity.getMemberName())
                    .auth(responseEntity.getAuth())
                    .studentNumber(responseEntity.getStudentNumber())
                    .department(responseEntity.getDepartment())
                    .profileImage(responseEntity.getProfileImage())
                    .isMember(responseEntity.getAuth() != null ? true : false)
                    .area(responseEntity.getArea())
                    .memberTimeTable(resMemberTimetables)
                    .build();
            return ResponseEntity.ok().body(responseMemberDTO);
        } catch (Exception e) {

            String error = e.getMessage();
            BaseResponseDTO<MemberResponseDTO> responseDTO = BaseResponseDTO.<MemberResponseDTO>builder().error(error)
                    .build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/api/test/h")
    public void createMember(@RequestBody MemberRequestDTO requestDTO) {
        memberService.createMember(requestDTO);
    }
}
