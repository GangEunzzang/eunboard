package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.TicketDTO;
import com.example.eunboard.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/auth/test")
    public String authTest() {
        return "인증 불필요 성공";
    }

    @PostMapping("/auth/test")
    public String authTest(@AuthenticationPrincipal long memberId) {
        return "인증 필요 성공";
    }
}
