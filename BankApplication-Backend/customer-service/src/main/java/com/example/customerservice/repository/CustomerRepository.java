package com.example.customerservice.repository;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.entity.KycStatus;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	    Optional<Customer> findByEmail(String email);
	    Page<Customer> findByKycStatus(KycStatus status, Pageable pageable);

}
