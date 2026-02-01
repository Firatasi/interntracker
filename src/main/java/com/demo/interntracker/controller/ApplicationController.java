package com.demo.interntracker.controller;

import com.demo.interntracker.dto.request.ApplicationRequest;
import com.demo.interntracker.dto.request.UpdateApplicationStatusRequest;
import com.demo.interntracker.dto.request.UpdateFollowUpDateRequest;
import com.demo.interntracker.dto.response.ApplicationResponse;
import com.demo.interntracker.entity.ApplicationStatus;
import com.demo.interntracker.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService) { this.applicationService = applicationService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponse create(@Valid @RequestBody ApplicationRequest req) {
        return applicationService.create(req);
    }

    // örnek: /api/applications?status=APPLIED&page=0&size=10&sort=appliedDate,desc
    @GetMapping
    public Page<ApplicationResponse> getAll(
            @RequestParam(required = false) ApplicationStatus status,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        return applicationService.getAll(status, pageable);
    }

    @PatchMapping("/{id}/status")
    public ApplicationResponse updateStatus(@PathVariable Long id,
                                            @Valid @RequestBody UpdateApplicationStatusRequest req) {
        return applicationService.updateStatus(id, req);
    }

    @PatchMapping("/{id}/follow-up-date")
    public ApplicationResponse updateFollowUpDate(@PathVariable Long id,
                                                  @Valid @RequestBody UpdateFollowUpDateRequest req) {
        return applicationService.updateFollowUpDate(id, req);
    }
}
