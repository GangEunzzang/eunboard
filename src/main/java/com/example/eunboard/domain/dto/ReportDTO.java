package com.example.eunboard.domain.dto;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReportDTO {

    private String writerStudentId;

    private String reportStudentId;

    private String content;
}
