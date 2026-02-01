package com.demo.interntracker.repository;

import com.demo.interntracker.entity.Application;
import com.demo.interntracker.entity.ApplicationStatus;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Page<Application> findByStatus(ApplicationStatus status, Pageable pageable);
}
