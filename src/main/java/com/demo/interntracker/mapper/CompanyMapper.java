package com.demo.interntracker.mapper;

import com.demo.interntracker.dto.request.CompanyRequest;
import com.demo.interntracker.dto.response.CompanyResponse;
import com.demo.interntracker.entity.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyRequest req);
    CompanyResponse toResponse(Company company);
    List<CompanyResponse> toResponseList(List<Company> companies);
}
