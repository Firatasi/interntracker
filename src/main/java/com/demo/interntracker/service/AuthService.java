package com.demo.interntracker.service;

import com.demo.interntracker.dto.request.LoginRequest;
import com.demo.interntracker.dto.request.RegisterRequest;
import com.demo.interntracker.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest req);
    AuthResponse login(LoginRequest req);
}
