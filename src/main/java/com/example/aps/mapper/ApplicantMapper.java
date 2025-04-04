package com.example.aps.mapper;

import com.example.aps.dto.applicant.ApplicantRequest;
import com.example.aps.dto.applicant.ApplicantResponse;
import com.example.aps.entity.Applicant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    ApplicantMapper INSTANCE = Mappers.getMapper(ApplicantMapper.class);

    Applicant toEntity(ApplicantRequest applicantReq);
    ApplicantResponse toDto(Applicant applicant);
}