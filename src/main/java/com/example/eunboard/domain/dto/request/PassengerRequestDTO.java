package com.example.eunboard.domain.dto.request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PassengerRequestDTO {

    private Long ticKetId;

    private String StudentId;

    private String passengerStudentId;
}
