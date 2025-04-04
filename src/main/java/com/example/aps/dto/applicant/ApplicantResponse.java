package com.example.aps.dto.applicant;

import lombok.Data;

@Data
public class ApplicantResponse {
    private int id;
    private String productType;
    private String productProgram;
    private String cardType;
    private String campaignCode;
    private boolean isVip;
    private String appStatus;
}
