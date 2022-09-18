package com.example.eunboard.domain.dto;

import com.example.eunboard.domain.entity.MemberRole;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDTO {

    /** 학번 */
    private String studentId;

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

    /** 프로필 이미지*/
    private String profileImage;

}
