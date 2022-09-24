package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.Ticket;
import com.example.eunboard.domain.entity.TicketStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static com.example.eunboard.domain.entity.QTicket.ticket;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Repository
public class TicketQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    public List<Ticket> findAll() {
        return queryFactory
                .selectFrom(ticket)
                .where(ticket.status.eq(TicketStatus.AFTER).not())
                .fetch();
    }
}
