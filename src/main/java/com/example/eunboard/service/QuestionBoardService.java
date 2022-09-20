package com.example.eunboard.service;

import com.example.eunboard.domain.dto.ReportDTO;
import com.example.eunboard.domain.entity.QuestionBoard;
import com.example.eunboard.domain.repository.QuestionBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionBoardService {

    private final QuestionBoardRepository questionBoardRepository;

    // 게시판 생성
    public void createQuestionBoard(ReportDTO reportDTO) {
        QuestionBoard board = ReportDTO.toQuestionEntity(reportDTO);
        questionBoardRepository.save(board);
    }
}
