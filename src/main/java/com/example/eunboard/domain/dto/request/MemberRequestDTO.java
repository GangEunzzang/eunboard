package com.example.eunboard.domain.dto.request;

import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.MemberRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberRequestDTO {

    @JsonIgnore
    private long id;

    /** 인증토큰 */
    @JsonIgnore
    private String token;

    /** 학번 */
    private String studentNumber;

    /** 이메일 */
    private String email;

    /** 비밀번호 */
    private String password;

    /** 이름 */
    private String name;

    /** 학과 */
    private String department;

    /** 연락처 */
    private String phoneNumber;

    /** 권한 */
    private MemberRole auth;

    /** 프로필 이미지 */
    private String profileImage;

    /** 등교일 */
    private List<String> memberTimeTable = new ArrayList<>();

    public static Member toEntity(MemberRequestDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Member.class);
    }

}
