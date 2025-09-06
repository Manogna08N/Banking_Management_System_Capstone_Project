package com.example.accountservice.service;

import com.example.accountservice.dto.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {
	 private final RestTemplate restTemplate;

	    // adjust to your customer-service base URL
	    private final String customerServiceBase = "http://localhost:8081";

	    public CustomerClient(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    public String getKycStatus(Long customerId) {
	        String url = customerServiceBase + "/customers/" + customerId;

	        ResponseEntity<CustomerResponse> resp =
	                restTemplate.getForEntity(url, CustomerResponse.class);

	        if (!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
	            throw new RuntimeException("Unable to fetch customer details");
	        }

	        return resp.getBody().getKycStatus();
	    }
}