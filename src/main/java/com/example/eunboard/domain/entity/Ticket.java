package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "ticket")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    /** 드라이버 정보 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    /** 출발요일 및 시간 */
    @Column(name = "start_dtime")
    private LocalDateTime startDtime;

    /** 오픈채팅방 링크 */
    @Column(name = "kakao_open_chat_url")
    private String kakaoOpenChatUrl;

    /** 오픈채팅방 이름 */
    @Column(name = "kakao_open_chat_title")
    private String kakaoOpenChatTitle;

    /** 티켓 비용 (0=무료) */
    @ColumnDefault("0")
    @Column(name = "ticket_price", length = 1, columnDefinition = "TINYINT")
    private int ticketPrice;

    /** 티켓 상태 (-1:취소, 0:운행전, 1:운행중, 2:운행완료) */
    @ColumnDefault("0")
    @Column(name = "status", length = 1, columnDefinition = "TINYINT")
    private String status;

    /** 탑승 인원 */
    @ColumnDefault("0")
    @Column(name = "recruit_person", length = 1, columnDefinition = "TINYINT")
    private int recruitPerson;

    /**
     * 출발지 안동:1 옥계:2 경운대:3 대구:4
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "start_area", length = 1, columnDefinition = "TINYINT")
    private Area startArea;

    /**
     * 도착지 경운대:3
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "end_area", length = 1, columnDefinition = "TINYINT")
    private Area endArea;

    /** 탑승자 연관관계 */
    @OneToMany(mappedBy = "ticket")
    @ToString.Exclude
    private List<Passenger> passengerList = new ArrayList<>();

}
