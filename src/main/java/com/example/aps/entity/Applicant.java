package com.example.aps.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AppId")
    private Long id;
    @Column(name = "ProductType")
    private String productType;
    @Column(name = "ProductProgram")
    private String productProgram;
    @Column(name = "CardType")
    private String cardType;
    @Column(name = "CampaignCode")
    private String campaignCode;
    @Column(name = "IsVip")
    private Boolean isVip;
    @Column(name = "AppStatus")
    private String appStatus;
    @Column(name = "CreatedOn")
    private LocalDateTime createdOn;
    @Column(name = "ModifiedOn")
    private LocalDateTime modifiedOn;
}
