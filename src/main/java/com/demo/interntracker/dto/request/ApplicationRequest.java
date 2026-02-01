package com.demo.interntracker.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ApplicationRequest {
    @NotNull
    private Long positionId;

    @NotNull
    private LocalDate appliedDate;

    private LocalDate followUpDate;

    @Size(max = 500)
    private String note;
}
