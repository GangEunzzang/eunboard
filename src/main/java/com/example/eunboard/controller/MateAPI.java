package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.TicketDTO;
import com.example.eunboard.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MateAPI {

    private final TicketService ticketService;

    @PostMapping("/mate/api/test")
    public void createTest(TicketDTO ticketDTO) {
        ticketService.createTicket(ticketDTO);
    }
}
