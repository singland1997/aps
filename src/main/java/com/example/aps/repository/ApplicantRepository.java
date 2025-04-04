package com.example.aps.repository;

import com.example.aps.entity.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Applicant> findById(Long id);
    Page<Applicant> findAll(Pageable pageable);
}
