package com.demo.interntracker.service;

import com.demo.interntracker.dto.request.PositionRequest;
import com.demo.interntracker.dto.response.PositionResponse;

import java.util.List;

public interface PositionService {
    PositionResponse create(PositionRequest req);
    PositionResponse getById(Long id);
    List<PositionResponse> getAll(Long companyId);
    void delete(Long id);
}
