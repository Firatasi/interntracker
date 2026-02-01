package com.demo.interntracker.dto.request;

import com.demo.interntracker.entity.WorkType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionRequest {
    @NotBlank @Size(max = 120)
    private String title;

    @NotNull
    private WorkType type;

    @NotNull
    private Long companyId;
}
