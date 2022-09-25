package com.example.eunboard.service;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.MemberResponseDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.repository.MemberRepository;
import com.example.eunboard.domain.repository.MemberTimetableRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberTimetableRepository memberTimetableRepository;

    public MemberResponseDTO select(final Long id) {
        return MemberResponseDTO.toDTO(memberRepository.findById(id).get(), null);
    }

    public void updatMember(final Long memberId, final MemberRequestDTO requestDTO) {
        if (null == requestDTO) {
            throw new RuntimeException("Invalid arguments");
        }
        requestDTO.setMemberId(memberId);
        requestDTO.setMember(true);
        memberRepository.save(MemberRequestDTO.toEntity(requestDTO));
    }

    public Member create(final MemberRequestDTO requestDTO) {
        if (null == requestDTO || null == requestDTO.getEmail()) {
            throw new RuntimeException("Invalid arguments");
        }

        final String email = requestDTO.getEmail();
        if (memberRepository.existsByEmail(email)) {
            log.debug("MemberService.create Email already exists {}", email);
            return memberRepository.findByEmail(email);
        }
        return memberRepository.save(MemberRequestDTO.toKakaoEntity(requestDTO));
    }

    public void updateMemberArea(final Long memberId, final MemberRequestDTO requestDTO) {
        if (null == requestDTO.getArea()) {
            throw new RuntimeException("Invalid arguments");
        }

        Member member = memberRepository.findById(memberId).get();
        member.setArea(requestDTO.getArea());

        memberRepository.save(member);
    }

}
