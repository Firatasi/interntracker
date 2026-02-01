package com.demo.interntracker.service.Impl;

import com.demo.interntracker.dto.request.ApplicationRequest;
import com.demo.interntracker.dto.request.UpdateApplicationStatusRequest;
import com.demo.interntracker.dto.request.UpdateFollowUpDateRequest;
import com.demo.interntracker.dto.response.ApplicationResponse;
import com.demo.interntracker.entity.*;
import com.demo.interntracker.exception.NotFoundException;
import com.demo.interntracker.mapper.ApplicationMapper;
import com.demo.interntracker.repository.ApplicationRepository;
import com.demo.interntracker.repository.PositionRepository;
import com.demo.interntracker.service.ApplicationService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final PositionRepository positionRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  PositionRepository positionRepository,
                                  ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.positionRepository = positionRepository;
        this.applicationMapper = applicationMapper;
    }

    @Override
    public ApplicationResponse create(ApplicationRequest req) {
        Position position = positionRepository.findById(req.getPositionId())
                .orElseThrow(() -> new NotFoundException("Position not found: " + req.getPositionId()));

        Application app = Application.builder()
                .position(position)
                .status(ApplicationStatus.APPLIED)
                .appliedDate(req.getAppliedDate())
                .followUpDate(req.getFollowUpDate())
                .note(req.getNote())
                .build();

        return applicationMapper.toResponse(applicationRepository.save(app));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ApplicationResponse> getAll(ApplicationStatus status, Pageable pageable) {
        Page<Application> page = (status == null)
                ? applicationRepository.findAll(pageable)
                : applicationRepository.findByStatus(status, pageable);

        return page.map(applicationMapper::toResponse);
    }

    @Override
    public ApplicationResponse updateStatus(Long id, UpdateApplicationStatusRequest req) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Application not found: " + id));

        app.setStatus(req.getStatus());
        return applicationMapper.toResponse(applicationRepository.save(app));
    }

    @Override
    public ApplicationResponse updateFollowUpDate(Long id, UpdateFollowUpDateRequest req) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Application not found: " + id));

        app.setFollowUpDate(req.getFollowUpDate());
        return applicationMapper.toResponse(applicationRepository.save(app));
    }
}
