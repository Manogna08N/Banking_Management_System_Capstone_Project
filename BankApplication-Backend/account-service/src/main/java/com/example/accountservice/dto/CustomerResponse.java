package com.example.accountservice.dto;

public class CustomerResponse {
	private Long id;
    private String name;
    private String kycStatus;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getKycStatus() {
        return kycStatus;
    }
    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

}
