package com.example.aps.service;

import com.example.aps.dto.applicant.ApplicantRequest;
import com.example.aps.dto.applicant.ApplicantResponse;
import com.example.aps.entity.Applicant;
import com.example.aps.mapper.ApplicantMapper;
import com.example.aps.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    public Optional<ApplicantResponse> getApplicant(int id) {
        try {
            return applicantRepository.findById((long) id)
                    .map(applicantMapper::toDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Error getting applicant", e);
        }
    }

    public Page<ApplicantResponse> getApplicants(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            return applicantRepository.findAll(pageRequest)
                    .map(applicantMapper::toDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Error getting applicants", e);
        }
    }

    public ApplicantResponse createApplicant(ApplicantRequest applicantReq) {
        try {
            Applicant saved = applicantRepository.save(applicantMapper.toEntity(applicantReq));
            return applicantMapper.toDto(saved);
        } catch (Exception e) {
            log.error("Error while creating applicant: {}", e.getMessage(), e);
            throw new RuntimeException("Cannot create applicant", e);
        }
    }

    public ApplicantResponse updateApplicant(ApplicantRequest applicant) {
        try {
            Applicant saved = applicantRepository.save(applicantMapper.toEntity(applicant));
            return applicantMapper.toDto(saved);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Cannot update applicant", e);
        }
    }

    public String deleteApplicant(int id) {
        try {
            applicantRepository.deleteById((long) id);
            return "applicant deleted";
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Cannot delete applicant", e);
        }
    }
}
