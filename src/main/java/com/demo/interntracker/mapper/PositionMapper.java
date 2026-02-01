package com.demo.interntracker.mapper;

import com.demo.interntracker.dto.request.PositionRequest;
import com.demo.interntracker.dto.response.PositionResponse;
import com.demo.interntracker.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "companyName", source = "company.name")
    PositionResponse toResponse(Position position);

    List<PositionResponse> toResponseList(List<Position> positions);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true) // company serviste set edilecek
    Position toEntity(PositionRequest req);
}
