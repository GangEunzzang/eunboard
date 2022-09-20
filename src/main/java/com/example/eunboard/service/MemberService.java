package com.example.eunboard.service;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member create(final Member memberEntity) {
        if (null == memberEntity || null == memberEntity.getEmail()) {
            throw new RuntimeException("Invalid arguments");
        }
        final String email = memberEntity.getEmail();
        if (memberRepository.existsByEmail(email)) {
            log.debug("MemberService.create Email already exists {}", email);
            return memberRepository.findByEmail(email);
        }
        return memberRepository.save(memberEntity);
    }

    public void createMember(MemberRequestDTO requestDTO) {
        // TODO : 프론트쪽에서 한번에 넘겨준대서 이런식으로 처리.
        // TODO : 추후 일괄적으로 예외처리 예정
        // Boolean exists = memberRepository.memberExists(requestDTO.getEmail());
        //
        // if (exists != null) {
        Member member = MemberRequestDTO.toEntity(requestDTO);
        memberRepository.save(member);
    }

}
