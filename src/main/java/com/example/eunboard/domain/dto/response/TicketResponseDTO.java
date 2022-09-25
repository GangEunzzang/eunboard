package com.example.eunboard.domain.dto.response;

import com.example.eunboard.domain.entity.Area;
import com.example.eunboard.domain.entity.Passenger;
import com.example.eunboard.domain.entity.Ticket;
import com.example.eunboard.domain.entity.TicketStatus;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TicketResponseDTO {

    private Long id;

    private String profileImage;

    private String startDtime;

    private String kakaoOpenChatUrl;

    private String kakaoOpenChatTitle;

    private String ticketPrice;

    private TicketStatus status;

    private String recruitPerson;

    private Area startArea;

    private Area endArea;

    private List<Passenger> passengerList = new ArrayList<>();

    public static TicketResponseDTO toDTO(Ticket entity) {
        return TicketResponseDTO.builder()
                .id(entity.getId())
                .profileImage(entity.getMember().getProfileImage())
                .startDtime(entity.getStartDtime())
                .kakaoOpenChatTitle(entity.getKakaoOpenChatTitle())
                .kakaoOpenChatUrl(entity.getKakaoOpenChatUrl())
                .ticketPrice(entity.getTicketPrice())
                .status(entity.getStatus())
                .recruitPerson(entity.getRecruitPerson())
                .startArea(entity.getStartArea())
                .endArea(entity.getEndArea())
                .build();
    }
}
