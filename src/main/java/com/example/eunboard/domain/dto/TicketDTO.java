package com.example.eunboard.domain.dto;

import com.example.eunboard.domain.entity.Ticket;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class TicketDTO {

    private Long id;

    private String studentId; // 드라이버 아이디

    private String startPoint;

    private String endPoint;

    private String departDay;

    private String departTime;

    private String kakaoOpenChatTitle;

    private String kakaoOpenChatUrl;

    private LocalDateTime ticketCreateDay;

    private String recruitPerson;

    private String isFinished;

    public static TicketDTO toDTO(Ticket entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, TicketDTO.class);
    }

    public static Ticket toEntity(TicketDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Ticket.class);
    }
}
