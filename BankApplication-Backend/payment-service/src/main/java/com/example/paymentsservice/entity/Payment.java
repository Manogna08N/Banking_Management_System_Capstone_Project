package com.example.paymentsservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String externalId;
	    private Long fromAccountId;
	    private String beneficiaryName;
	    private String beneficiaryBankCode;
	    private String beneficiaryAccountNo;
	    private BigDecimal amount;

	    private String status; // SUCCESS / FAILED

	    // Getters and setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getExternalId() { return externalId; }
	    public void setExternalId(String externalId) { this.externalId = externalId; }

	    public Long getFromAccountId() { return fromAccountId; }
	    public void setFromAccountId(Long fromAccountId) { this.fromAccountId = fromAccountId; }

	    public String getBeneficiaryName() { return beneficiaryName; }
	    public void setBeneficiaryName(String beneficiaryName) { this.beneficiaryName = beneficiaryName; }

	    public String getBeneficiaryBankCode() { return beneficiaryBankCode; }
	    public void setBeneficiaryBankCode(String beneficiaryBankCode) { this.beneficiaryBankCode = beneficiaryBankCode; }

	    public String getBeneficiaryAccountNo() { return beneficiaryAccountNo; }
	    public void setBeneficiaryAccountNo(String beneficiaryAccountNo) { this.beneficiaryAccountNo = beneficiaryAccountNo; }

	    public BigDecimal getAmount() { return amount; }
	    public void setAmount(BigDecimal amount) { this.amount = amount; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }
}
