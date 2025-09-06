package com.example.customerservice.dto;

import com.example.customerservice.entity.KycDocStatus;
import java.time.Instant;

public record KycDocResponse(Long id,
        String docType,
        String docUrl,
        KycDocStatus status,
        Instant uploadedAt
) {}
