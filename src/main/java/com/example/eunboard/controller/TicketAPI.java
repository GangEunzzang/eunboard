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
@RequestMapping("/ticket")
@RestController
public class TicketAPI {

  private final TicketService ticketService;


  @PostMapping("/new")
  public void ticketCreate(@RequestBody TicketRequestDTO requestDTO) {
    ticketService.save(requestDTO);
  }

  @ResponseBody
  @GetMapping("/list")
  public List<TicketResponseDTO> findAll() {
    return ticketService.findAll();
  }

  @ResponseBody
  @GetMapping("/read/{id}")
  public TicketResponseDTO read(@PathVariable long id) {
    return ticketService.read(id);
  }

  @GetMapping("/delete/{id}")
  public void delete(@PathVariable long id) {
    ticketService.delete(id);
  }
  
}
