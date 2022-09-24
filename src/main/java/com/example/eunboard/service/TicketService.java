package com.example.eunboard.service;

import com.example.eunboard.domain.dto.request.TicketRequestDTO;
import com.example.eunboard.domain.dto.response.TicketResponseDTO;
import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.Ticket;
import com.example.eunboard.domain.repository.MemberRepository;
import com.example.eunboard.domain.repository.TicketQueryRepository;
import com.example.eunboard.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketQueryRepository ticketQueryRepository;

    private final MemberRepository memberRepository;

    // 티켓 생성
    public void save(TicketRequestDTO ticketDTO) {
        Ticket ticket = TicketRequestDTO.toEntity(ticketDTO);
        ticketRepository.save(ticket);
    }

    public List<TicketResponseDTO> listAll() {
        List<Ticket> ticketList = ticketQueryRepository.findAll();
        return ticketList.stream().map(TicketResponseDTO::toDTO).collect(Collectors.toList());
    }
}
