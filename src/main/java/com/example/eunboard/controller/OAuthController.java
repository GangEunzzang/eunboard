package com.example.eunboard.controller;

import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.service.KakaoAPI;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@Slf4j
public class OAuthController {



    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "";
    }

    KakaoAPI kakaoApi = new KakaoAPI();

    //@Autowired
    //private MemberService memberService;

    //@Autowired
    //private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value="/kakaoLogin")
    public ResponseEntity<?> kakaoLogin(@RequestParam("code") String code) {

        String accessToken = kakaoApi.getAccessToken(code);
        JsonObject userInfo = kakaoApi.getUserInfo(accessToken); // 인증코드로 토큰 전달

        userInfo.addProperty("isMember", 1);

        System.out.println("login info : " + userInfo.get("isMember"));

        return ResponseEntity.ok().body(userInfo);

        /*try {
            String accessToken = kakaoApi.getAccessToken(code);
            MemberDTO memberDTO = kakaoApi.getUserInfo(accessToken);

            *//*Member kakaoUser = Member.builder()
                    .email(member.get())
                    .memberName(memberDTO.getName())
                    .password(passwordEncoder.encode(memberDTO.getPassword())).build();

            Member registeredMember = memberService.create(kakaoUser);*//*

            if (null != registeredMember) {
                //final String token = tokenProvider.create(registeredMember);
                final MemberDTO responseMemberDTO = MemberDTO.builder()
                        .email(registeredMember.getEmail())
                        .memberId(registeredMember.getMemberId())
                        .token("token")
                        .build();

                return ResponseEntity.ok().body(responseMemberDTO);
            } else {
                ResponseDTO<MemberDTO> responseDTO = ResponseDTO.<MemberDTO>builder().error("Login failed.").build();
                return ResponseEntity.badRequest().body(responseDTO);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<MemberDTO> responseDTO = ResponseDTO.<MemberDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }*/

    }

}


