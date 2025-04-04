package com.example.aps.controller;

import com.example.aps.dto.applicant.ApplicantRequest;
import com.example.aps.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class ApplicantController {
    private final ApplicantService applicantService;

    @GetMapping
    public ResponseEntity<?> getAllApplicants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(applicantService.getApplicants(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicant(@PathVariable int id) {
        return ResponseEntity.ok(applicantService.getApplicant(id));
    }

    @PostMapping
    public ResponseEntity<?> createApplicant(@RequestBody ApplicantRequest applicant) {
        return ResponseEntity.ok(applicantService.createApplicant(applicant));
    }

    @PutMapping
    public ResponseEntity<?> updateApplicant(@RequestBody ApplicantRequest applicant) {
        return ResponseEntity.ok(applicantService.updateApplicant(applicant));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteApplicant(@PathVariable int id) {
        return ResponseEntity.ok(applicantService.deleteApplicant(id));
    }
}
