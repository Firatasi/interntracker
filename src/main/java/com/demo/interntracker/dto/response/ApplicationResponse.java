package com.demo.interntracker.dto.response;

import com.demo.interntracker.entity.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ApplicationResponse {
    private Long id;

    private Long positionId;
    private String positionTitle;

    private Long companyId;
    private String companyName;

    private ApplicationStatus status;
    private LocalDate appliedDate;
    private LocalDate followUpDate;
    private String note;
}
