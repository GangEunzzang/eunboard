package com.example.eunboard.service;

import com.example.eunboard.domain.dto.request.TicketRequestDTO;
import com.example.eunboard.domain.dto.response.TicketResponseDTO;
import com.example.eunboard.domain.entity.Ticket;
import com.example.eunboard.domain.repository.MemberRepository;
import com.example.eunboard.domain.repository.TicketQueryRepository;
import com.example.eunboard.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketQueryRepository ticketQueryRepository;

    private final MemberRepository memberRepository;

    // 티켓 생성
    public void save(TicketRequestDTO requestDTO) {
        Ticket ticket = TicketRequestDTO.toEntity(requestDTO);
        ticketRepository.save(ticket);
    }

    // 티켓 목록 조회
    public List<TicketResponseDTO> findAll() {
        List<Ticket> ticketList = ticketQueryRepository.findAll();
        return ticketList.stream().map(TicketResponseDTO::toDTO).collect(Collectors.toList());
    }

    // 티켓 상세보기
    public TicketResponseDTO read(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return TicketResponseDTO.toDTO(ticket.get());
    }

    // 티켓 삭제
    public void delete(long id) {
        ticketRepository.deleteById(id);
    }
}
