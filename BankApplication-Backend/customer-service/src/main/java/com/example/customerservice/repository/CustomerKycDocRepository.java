package com.example.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customerservice.entity.CustomerKycDoc;

public interface CustomerKycDocRepository extends JpaRepository<CustomerKycDoc, Long> {

}
