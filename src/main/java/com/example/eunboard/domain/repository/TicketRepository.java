package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}