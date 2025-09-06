package com.example.accountservice.repository;

import java.util.List;
import java.util.Optional;

import com.example.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
	// Custom query method to fetch all accounts of a given customer
	 List<Account> findByCustomerId(Long customerId);
	 Optional<Account> findByAccountNo(String accountNo);
	 
}
