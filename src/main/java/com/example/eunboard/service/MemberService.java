package com.example.eunboard.service;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(MemberRequestDTO requestDTO) {
        //TODO : 프론트쪽에서 한번에 넘겨준대서 이런식으로 처리.
        //TODO : 추후 일괄적으로 예외처리 예정
//        Boolean exists = memberRepository.memberExists(requestDTO.getEmail());
//
//        if (exists != null) {
        Member member = MemberRequestDTO.toEntity(requestDTO);
        memberRepository.save(member);
    }

}

