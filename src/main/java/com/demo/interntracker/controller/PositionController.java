package com.demo.interntracker.controller;

import com.demo.interntracker.dto.request.PositionRequest;
import com.demo.interntracker.dto.response.PositionResponse;
import com.demo.interntracker.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private final PositionService positionService;
    public PositionController(PositionService positionService) { this.positionService = positionService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PositionResponse create(@Valid @RequestBody PositionRequest req) {
        return positionService.create(req);
    }

    @GetMapping("/{id}")
    public PositionResponse getById(@PathVariable Long id) {
        return positionService.getById(id);
    }

    // /api/positions?companyId=1
    @GetMapping
    public List<PositionResponse> getAll(@RequestParam(required = false) Long companyId) {
        return positionService.getAll(companyId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        positionService.delete(id);
    }
}
