package com.demo.interntracker.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateFollowUpDateRequest {
    @NotNull
    private LocalDate followUpDate;
}
