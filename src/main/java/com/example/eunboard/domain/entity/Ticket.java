package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    /**  출발지 */
    @Column(name = "start_point")
    private String startPoint;

    /** 도착지 */
    @Column(name = "end_point")
    private String endPoint;

    /** 요일 */
    @Column(name = "depart_day")
    private String departDay;

    /** 시간 */
    @Column(name = "depart_time")
    private String departTime;

    /** 오픈채팅방 링크*/
    @Column(name = "kakao_open_chat_url")
    private String kakaoOpenChatUrl;

    /** 오픈채팅방 이름 */
    @Column(name = "kakao_open_chat_title")
    private String kakaoOpenChatTitle;

    /** 탑승 인원 */
    @Column(name = "recruit_person")
    private String recruitPerson;
}
