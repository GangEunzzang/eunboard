package com.example.eunboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eunboard.domain.dto.TicketDTO;
import com.example.eunboard.domain.dto.response.BaseResponseDTO;
import com.example.eunboard.service.TicketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TicketAPI {

  private final TicketService ticketService;

  @ResponseBody
  @GetMapping("/ticket")
  public ResponseEntity<?> getTicketList(@AuthenticationPrincipal Long memberId) {
    try {
      BaseResponseDTO<TicketDTO> responseDTO = BaseResponseDTO.<TicketDTO>builder()
          .data(ticketService.selectTicketList()).build();
      return ResponseEntity.ok().body(responseDTO);
    } catch (Exception e) {
      BaseResponseDTO<TicketDTO> responseDTO = BaseResponseDTO.<TicketDTO>builder().error(e.getMessage()).build();
      return ResponseEntity.badRequest().body(responseDTO);
    }
  }

  @ResponseBody
  @PostMapping("/ticket/new")
  public String ticketCreate(@AuthenticationPrincipal Long memberId,
      TicketDTO ticketDTO) {

    System.out.println("요청자 아이디 : " + memberId);
    System.out.println("ticketDTO : " + ticketDTO);

    return "티켓생성";
  }
}