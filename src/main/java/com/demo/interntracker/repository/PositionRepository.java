package com.demo.interntracker.repository;

import com.demo.interntracker.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByCompanyId(Long companyId);
}
