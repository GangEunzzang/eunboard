package com.example.eunboard.controller;

import com.example.eunboard.domain.entity.Ticket;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eunboard.domain.dto.TicketDTO;
import com.example.eunboard.service.TicketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TicketAPI {

  private final TicketService ticketService;


  @ResponseBody
  @PostMapping("/ticket/new")
  public String ticketCreate(@AuthenticationPrincipal Long memberId,
      TicketDTO ticketDTO) {

    System.out.println("요청자 아이디 : " + memberId);
    System.out.println("ticketDTO : " + ticketDTO);

    return "티켓생성";
  }

  @ResponseBody
  @GetMapping("/ticket/list")
  public List<Ticket> ticketList() {
    return ticketService.listTicket();
  }
}
