package com.example.eunboard.domain.entity;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

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
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    /** 학번 */
    @Column(name = "student_number")
    private String studentNumber;

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
    @Column(length = 10)
    private MemberRole auth;

    /** 프로필 이미지 */
    @Column(name = "profile_image")
    private String profileImage;

    /** 탈퇴여부 */
    @ColumnDefault("0")
    @Column(name = "is_removed", columnDefinition = "TINYINT", length = 1)
    private int isRemoved;

    /** 탈퇴일자 */
    @Column(name = "delete_date", length = 10)
    private Date deleteDate;


}
