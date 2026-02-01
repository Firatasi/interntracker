package com.demo.interntracker.service;

import com.demo.interntracker.dto.request.CompanyRequest;
import com.demo.interntracker.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse create(CompanyRequest req);
    CompanyResponse getById(Long id);
    List<CompanyResponse> getAll();
    CompanyResponse update(Long id, CompanyRequest req);
    void delete(Long id);
}
