package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Board, Long> {
}