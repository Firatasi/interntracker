package com.demo.interntracker.service.Impl;

import com.demo.interntracker.dto.request.PositionRequest;
import com.demo.interntracker.dto.response.PositionResponse;
import com.demo.interntracker.entity.Company;
import com.demo.interntracker.entity.Position;
import com.demo.interntracker.exception.NotFoundException;
import com.demo.interntracker.mapper.PositionMapper;
import com.demo.interntracker.repository.CompanyRepository;
import com.demo.interntracker.repository.PositionRepository;
import com.demo.interntracker.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final CompanyRepository companyRepository;
    private final PositionMapper positionMapper;

    public PositionServiceImpl(PositionRepository positionRepository,
                               CompanyRepository companyRepository,
                               PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.companyRepository = companyRepository;
        this.positionMapper = positionMapper;
    }

    @Override
    public PositionResponse create(PositionRequest req) {
        Company company = companyRepository.findById(req.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found: " + req.getCompanyId()));

        Position position = positionMapper.toEntity(req);
        position.setCompany(company);

        return positionMapper.toResponse(positionRepository.save(position));
    }

    @Override
    @Transactional(readOnly = true)
    public PositionResponse getById(Long id) {
        Position p = positionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Position not found: " + id));
        return positionMapper.toResponse(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PositionResponse> getAll(Long companyId) {
        if (companyId == null) {
            return positionMapper.toResponseList(positionRepository.findAll());
        }
        return positionMapper.toResponseList(positionRepository.findByCompanyId(companyId));
    }

    @Override
    public void delete(Long id) {
        if (!positionRepository.existsById(id)) {
            throw new NotFoundException("Position not found: " + id);
        }
        positionRepository.deleteById(id);
    }
}
