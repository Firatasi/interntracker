package com.demo.interntracker.service.Impl;

import com.demo.interntracker.dto.request.CompanyRequest;
import com.demo.interntracker.dto.response.CompanyResponse;
import com.demo.interntracker.entity.Company;
import com.demo.interntracker.exception.NotFoundException;
import com.demo.interntracker.mapper.CompanyMapper;
import com.demo.interntracker.repository.CompanyRepository;
import com.demo.interntracker.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyResponse create(CompanyRequest req) {
        Company saved = companyRepository.save(companyMapper.toEntity(req));
        return companyMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyResponse getById(Long id) {
        Company c = companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found: " + id));
        return companyMapper.toResponse(c);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyResponse> getAll() {
        return companyMapper.toResponseList(companyRepository.findAll());
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest req) {
        Company c = companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found: " + id));

        c.setName(req.getName());
        c.setWebsite(req.getWebsite());
        c.setLocation(req.getLocation());

        return companyMapper.toResponse(companyRepository.save(c));
    }

    @Override
    public void delete(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new NotFoundException("Company not found: " + id);
        }
        companyRepository.deleteById(id);
    }
}
