package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class DummyInsertTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 회원_더미데이터_입력 () throws Exception {
        //given
        IntStream.rangeClosed(1,30).forEach(i -> {

            MemberRole role = MemberRole.valueOf("P");
            if(i <= 10) {
                role = MemberRole.valueOf("D");
            }
            Member member = Member.builder()
                    .auth(role)
                    .email("이메일" + i)
                    .department("학과" + i)
                    .password("비밀번호" + i)
                    .studentId("학번" + i)
                    .memberName("이름 " + i)
                    .phoneNumber("휴대폰" + i)
                    .build();

            memberRepository.save(member);
        });

        //when

        //then
     }
}
