package com.example.eunboard.domain.repository;

import com.example.eunboard.domain.entity.ReportBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportBoard, Long> {
}