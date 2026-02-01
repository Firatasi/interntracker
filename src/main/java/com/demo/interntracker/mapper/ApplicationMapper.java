package com.demo.interntracker.mapper;

import com.demo.interntracker.dto.response.ApplicationResponse;
import com.demo.interntracker.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "positionTitle", source = "position.title")
    @Mapping(target = "companyId", source = "position.company.id")
    @Mapping(target = "companyName", source = "position.company.name")
    ApplicationResponse toResponse(Application app);

    List<ApplicationResponse> toResponseList(List<Application> apps);
}
