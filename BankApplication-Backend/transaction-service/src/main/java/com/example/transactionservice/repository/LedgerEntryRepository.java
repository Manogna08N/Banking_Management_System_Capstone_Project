package com.example.transactionservice.repository;

import com.example.transactionservice.entity.LedgerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, Long> {
    List<LedgerEntry> findByAccountIdOrderByCreatedAtAscIdAsc(Long accountId);

}
