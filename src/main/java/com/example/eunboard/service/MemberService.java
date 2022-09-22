package com.example.eunboard.service;

import com.example.eunboard.domain.dto.request.MemberRequestDTO;
import com.example.eunboard.domain.dto.response.MemberTimetableResponseDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.MemberTimetable;
import com.example.eunboard.domain.repository.MemberRepository;
import com.example.eunboard.domain.repository.MemberTimetableRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberTimetableRepository memberTimetableRepository;

    public Member select(final Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.get();
    }

    public List<MemberTimetable> saveMemberTimetables(final Member memberEntity) {
        return memberTimetableRepository.saveAll(memberEntity.getMemberTimeTable());
    }

    public Member updatMember(final Long memberId, final Member memberEntity) {
        if (null == memberEntity) {
            throw new RuntimeException("Invalid arguments");
        }

        memberTimetableRepository.deleteAllInBatch(memberTimetableRepository.findByMember(memberEntity));

        Optional<Member> original = memberRepository.findById(memberId);
        original.get().setStudentNumber(memberEntity.getStudentNumber());
        original.get().setDepartment(memberEntity.getDepartment());
        original.get().setAuth(memberEntity.getAuth());
        original.get().setMemberName(memberEntity.getMemberName());
        original.get().setPhoneNumber(memberEntity.getPhoneNumber());
        original.get().setMember(true);
        original.get().setArea(memberEntity.getArea());

        return memberRepository.save(original.get());

    }

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

    public Member updateMemberArea(long memberId, Member memberEntity) {
        if (null == memberEntity.getArea()) {
            throw new RuntimeException("Invalid arguments");
        }

        Member member = memberRepository.findById(memberId).get();
        member.setArea(memberEntity.getArea());

        ModelMapper modelMapper = new ModelMapper();
        return memberRepository.save(modelMapper.map(member, Member.class));
    }

    public List<MemberTimetableResponseDTO> selectTimetables(Member memberEntity) {
        final List<MemberTimetableResponseDTO> resMemberTimetables = new ArrayList<>();
        memberTimetableRepository.findByMember(memberEntity).stream().forEach(timeTable -> {
            MemberTimetableResponseDTO memberTimetableDTO = MemberTimetableResponseDTO.builder()
                    .dayCode(timeTable.getDayCode()).build();
            resMemberTimetables.add(memberTimetableDTO);
        });

        return resMemberTimetables;
    }

}
