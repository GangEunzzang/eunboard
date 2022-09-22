package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.BaseResponseDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.security.TokenProvider;
import com.example.eunboard.service.KakaoAPI;
import com.example.eunboard.service.MemberService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kakaoLogin")
public class OAuthController {

    @Autowired
    private KakaoAPI kakaoService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // TODO: 토큰 리프레시

    @ResponseBody
    @GetMapping
    public ResponseEntity<?> kakaoLogin(@RequestParam String code) {

        try {
            String accessToken = kakaoService.getAccessToken(code);
            MemberRequestDTO memberDTO = kakaoService.getUserInfo(accessToken);
            memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
            memberDTO.setMember(false);

            Member member = MemberRequestDTO.toEntity(memberDTO);

            Member registeredMember = memberService.create(member);

            if (null != registeredMember) {
                final String token = tokenProvider.create(registeredMember);

                final MemberResponseDTO responseMemberDTO = MemberResponseDTO.builder()
                        .email(registeredMember.getEmail())
                        .memberId(registeredMember.getMemberId())
                        .token(token)
                        .isMember(registeredMember.getAuth() == null ? false : true)
                        .build();

                return ResponseEntity.ok().body(responseMemberDTO);
            } else {
                BaseResponseDTO<MemberResponseDTO> responseDTO = BaseResponseDTO.<MemberResponseDTO>builder()
                        .error("Login failed.").build();
                return ResponseEntity.badRequest().body(responseDTO);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            BaseResponseDTO<MemberResponseDTO> responseDTO = BaseResponseDTO.<MemberResponseDTO>builder().error(error)
                    .build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
