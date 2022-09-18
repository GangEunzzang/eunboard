package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Table(name = "member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    /** 학번 */
    @Column(name = "student_id")
    private String studentId;

    /** 이메일 */
    @Column(name = "email")
    private String email;

    /** 비밀번호 */
    @Column(name = "password")
    private String password;

    /** 이름 */
    @Column(name = "name")
    private String name;

    /** 학과 */
    @Column(name = "department")
    private String department;

    /** 연락처 */
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    /** 권한 */
    @Enumerated(EnumType.STRING)
    private MemberRole auth;

    /** 프로필 이미지*/
    @Column(name = "profile_image")
    private String profileImage;


}
