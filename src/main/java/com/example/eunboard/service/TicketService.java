package com.example.eunboard.service;

import com.example.eunboard.domain.dto.TicketDTO;
import com.example.eunboard.domain.entity.Ticket;
import com.example.eunboard.domain.repository.TicketQueryRepository;
import com.example.eunboard.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketQueryRepository ticketQueryRepository;
    // 티켓 생성
    public void createTicket(TicketDTO ticketDTO) {
        Ticket ticket = TicketDTO.toEntity(ticketDTO);
        ticketRepository.save(ticket);
    }

    public List<Ticket> listTicket() {
        return ticketQueryRepository.findAll();
    }
}
