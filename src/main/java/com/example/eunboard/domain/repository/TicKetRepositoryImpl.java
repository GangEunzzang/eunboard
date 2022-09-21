package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.Ticket;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import static com.example.eunboard.domain.entity.QTicket.ticket;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Slf4j
public class TicKetRepositoryImpl implements TicketCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Ticket> findAll() {
        return queryFactory.select(ticket).from(ticket).fetch();
    }
}
