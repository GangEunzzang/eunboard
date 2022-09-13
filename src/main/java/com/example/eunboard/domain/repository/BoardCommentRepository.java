package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
}