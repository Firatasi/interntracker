package com.demo.interntracker.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @Email @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, message = "password must be >= 6 chars")
    private String password;
}
