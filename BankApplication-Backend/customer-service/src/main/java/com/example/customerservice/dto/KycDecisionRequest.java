package com.example.customerservice.dto;

import jakarta.validation.constraints.NotBlank;

public record KycDecisionRequest(
		 String reason,
	        @NotBlank String actor   // who (email/name) took the action - simple audit
) { }
