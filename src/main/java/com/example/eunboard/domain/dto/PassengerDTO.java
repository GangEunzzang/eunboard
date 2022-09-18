package com.example.eunboard.domain.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PassengerDTO {

    private Long ticKetId;

    private String StudentId;

    private String passengerStudentId;
}
