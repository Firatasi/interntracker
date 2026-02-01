package com.demo.interntracker.service;

import com.demo.interntracker.dto.request.ApplicationRequest;
import com.demo.interntracker.dto.request.UpdateApplicationStatusRequest;
import com.demo.interntracker.dto.request.UpdateFollowUpDateRequest;
import com.demo.interntracker.dto.response.ApplicationResponse;
import com.demo.interntracker.entity.ApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {
    ApplicationResponse create(ApplicationRequest req);
    Page<ApplicationResponse> getAll(ApplicationStatus status, Pageable pageable);
    ApplicationResponse updateStatus(Long id, UpdateApplicationStatusRequest req);
    ApplicationResponse updateFollowUpDate(Long id, UpdateFollowUpDateRequest req);
}
