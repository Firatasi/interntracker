package com.demo.interntracker.service.Impl;

import com.demo.interntracker.dto.request.LoginRequest;
import com.demo.interntracker.dto.request.RegisterRequest;
import com.demo.interntracker.dto.response.AuthResponse;
import com.demo.interntracker.entity.AppUser;
import com.demo.interntracker.entity.Role;
import com.demo.interntracker.exception.BadRequestException;
import com.demo.interntracker.repository.UserRepository;
import com.demo.interntracker.security.JwtService;
import com.demo.interntracker.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        AppUser user = AppUser.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String token = jwtService.generate(req.getEmail());
        return AuthResponse.builder().token(token).tokenType("Bearer").build();
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        AppUser user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = jwtService.generate(user.getEmail());
        return AuthResponse.builder().token(token).tokenType("Bearer").build();
    }
}
