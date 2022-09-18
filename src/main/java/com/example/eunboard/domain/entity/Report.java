package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "report")
@ToString
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    /** 신고한 학번 */
    @Column(name = "writer_student_id")
    private String writerStudentId;

    /** 신고받은 학번 */
    @Column(name = "report_student_id")
    private String reportStudentId;

    /** 신고 내용 */
    @Column(name = "content")
    private String content;

}
