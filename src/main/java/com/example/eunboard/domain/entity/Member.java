package com.example.eunboard.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

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
    @Column(name = "member_name")
    private String memberName;

    /** 학과 */
    @Column(name = "department")
    private String department;

    /** 연락처 */
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    /** 권한 */
    @Enumerated(EnumType.STRING)
    private MemberRole auth;

    /** 프로필 이미지 */
    @Column(name = "profile_image")
    private String profileImage;

    /** 탈퇴여부 */
    @ColumnDefault("0")
    @Column(name = "is_removed", columnDefinition = "TINYINT", length = 1)
    private int isRemoved;

    /** 탈퇴일자 */
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
