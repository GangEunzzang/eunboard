package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Table(name = "member_timetable")
@Entity
public class MemberTimetable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_timetable_id")
  private Long id;

  /** 멤버 */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  @ToString.Exclude
  private Member member;

  /** 요일코드 (0~6 일~토) */
  @Column(columnDefinition = "TINYINT", length = 1, nullable = false)
  private int dayCode;
}
