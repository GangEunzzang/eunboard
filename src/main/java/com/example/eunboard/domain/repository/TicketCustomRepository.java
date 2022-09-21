package com.example.eunboard.domain.repository;

import java.util.List;

import com.example.eunboard.domain.entity.Ticket;

public interface TicketCustomRepository {
  public List<Ticket> findAll();
}
