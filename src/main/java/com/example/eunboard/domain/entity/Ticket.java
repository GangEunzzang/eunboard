package com.example.eunboard.domain.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "area_id")
    @ToString.Exclude
    private Area area;

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

    /** 생성일자 */
    @CreatedDate
    @Column(name="ticket_create_day",updatable=false)
    private LocalDateTime ticketCreateDay;

    /** 탑승 인원 */
    @Column(name = "recruit_person")
    private String recruitPerson;

    /** 완료 여부 */
    @Column(name = "is_finished", length = 5)
    private String isFinished;

    /** 탑승자 연관관계 */
    @OneToMany(mappedBy = "ticket")
    @ToString.Exclude
    private List<Passenger> passengerList = new ArrayList<>();

}
