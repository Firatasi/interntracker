package com.demo.interntracker.dto.request;

import com.demo.interntracker.entity.ApplicationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateApplicationStatusRequest {
    @NotNull
    private ApplicationStatus status;
}
