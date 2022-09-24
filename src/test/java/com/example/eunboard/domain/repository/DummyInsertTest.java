package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.MemberRole;
import com.example.eunboard.domain.entity.Ticket;
import com.example.eunboard.domain.entity.TicketStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class DummyInsertTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void 회원_더미데이터_입력() throws Exception {
        // given
        IntStream.rangeClosed(1, 30).forEach(i -> {

            MemberRole role = MemberRole.valueOf("PASSENGER");
            if (i <= 10) {
                role = MemberRole.valueOf("DRIVER");
            }
            Member member = Member.builder()
                    .auth(role)
                    .email("이메일" + i)
                    .department("학과" + i)
                    .password("비밀번호" + i)
                    .studentNumber("학번" + i)
                    .memberName("이름 " + i)
                    .phoneNumber("휴대폰" + i)
                    .build();

            memberRepository.save(member);
        });

        // when

        // then
    }

    @Test
    public void 티켓_더미데이터_입력 () throws Exception {
        //given
        IntStream.rangeClosed(1,30).forEach(i -> {
            Ticket ticket = Ticket.builder()
                    .member(Member.builder().memberId((long) i).build())
                    .startDtime("202209241530")
                    .kakaoOpenChatTitle("카카오 오픈채팅 이름" + i)
                    .kakaoOpenChatUrl("카카오 오픈채팅 링크" + i)
                    .ticketPrice("0")
                    .status(TicketStatus.BEFORE)
                    .startArea("옥계")
                    .endArea("경운대")
                    .build();
            ticketRepository.save(ticket);
        });
     }
}
