package com.example.accountservice.controller;

import com.example.accountservice.dto.AccountResponse;
import com.example.accountservice.dto.CreateAccountRequest;
import com.example.accountservice.dto.AmountRequest;
import com.example.accountservice.service.AccountAppService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"})
public class AccountController {

    private final AccountAppService service;

    public AccountController(AccountAppService service) {
        this.service = service;
    }

    // Create account
    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody CreateAccountRequest req) {
        return ResponseEntity.ok(service.createAccount(req));
    }

    // Get all accounts by customerId
    @GetMapping
    public ResponseEntity<List<AccountResponse>> byCustomer(@RequestParam Long customerId) {
        return ResponseEntity.ok(service.listByCustomer(customerId));
    }

    // Get account by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Debit account
    @PostMapping("/{id}/debit")
    public ResponseEntity<Void> debit(@PathVariable Long id, @Valid @RequestBody AmountRequest req) {
        service.debit(id, req.getAmount());
        return ResponseEntity.ok().build();
    }

    // Credit account
    @PostMapping("/{id}/credit")
    public ResponseEntity<Void> credit(@PathVariable Long id, @Valid @RequestBody AmountRequest req) {
        service.credit(id, req.getAmount());
        return ResponseEntity.ok().build();
    }
}
