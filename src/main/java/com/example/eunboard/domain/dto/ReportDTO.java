package com.example.eunboard.domain.dto;
import com.example.eunboard.domain.entity.QuestionBoard;
import com.example.eunboard.domain.entity.ReportBoard;
import com.example.eunboard.domain.entity.Ticket;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReportDTO {

    private String writerStudentId;

    private String writerEmail;

    private String reportStudentId;

    private String title;

    private String content;

    public static ReportDTO toDTO(ReportBoard entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, ReportDTO.class);
    }

    public static ReportBoard toReportEntity(ReportDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, ReportBoard.class);
    }

    public static QuestionBoard toQuestionEntity(ReportDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, QuestionBoard.class);
    }
}
