package com.demo.interntracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {
    @NotBlank @Size(max = 120)
    private String name;

    @Size(max = 200)
    private String website;

    @Size(max = 120)
    private String location;
}
