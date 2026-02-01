package com.demo.interntracker.dto.response;

import com.demo.interntracker.entity.WorkType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionResponse {
    private Long id;
    private String title;
    private WorkType type;
    private Long companyId;
    private String companyName;
}
