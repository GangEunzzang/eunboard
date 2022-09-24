package com.example.eunboard.controller;

import com.example.eunboard.domain.dto.request.TicketRequestDTO;
import com.example.eunboard.domain.dto.response.TicketResponseDTO;
import org.springframework.web.bind.annotation.*;

import com.example.eunboard.service.TicketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TicketAPI {

  private final TicketService ticketService;


  @PostMapping("/ticket/new")
  public void ticketCreate(@RequestBody TicketRequestDTO ticketRequestDTO) {
    System.out.println("ticketRequestDTO : " + ticketRequestDTO);
    ticketService.save(ticketRequestDTO);
  }

  @ResponseBody
  @GetMapping("/ticket/list")
  public List<TicketResponseDTO> ticketList() {
    return ticketService.listAll();
  }
}
