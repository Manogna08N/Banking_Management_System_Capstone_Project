package com.example.payment.controller;

import java.util.Random;

import com.example.paymentsservice.dto.PaymentRequest;
import com.example.paymentsservice.dto.PaymentResponse;
import com.example.paymentsservice.entity.Payment;
import com.example.paymentsservice.repository.PaymentRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"})
public class PaymentController {
	private final boolean simulateFailure;
    private final Random rnd = new Random();

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentController(@Value("${payments.simulate-failure:false}") boolean simulateFailure) {
        this.simulateFailure = simulateFailure;
    }

    @PostMapping("/transfer")
    public ResponseEntity<PaymentResponse> transfer(@Valid @RequestBody PaymentRequest req) {
        // Create a new Payment entity from the request
        Payment payment = new Payment();
        payment.setExternalId(req.getExternalId());
        payment.setFromAccountId(req.getFromAccountId());
        payment.setBeneficiaryName(req.getBeneficiaryName());
        payment.setBeneficiaryBankCode(req.getBeneficiaryBankCode());
        payment.setBeneficiaryAccountNo(req.getBeneficiaryAccountNo());
        payment.setAmount(req.getAmount());

        // Mock failure logic
        if (simulateFailure && rnd.nextBoolean()) {
            payment.setStatus("FAILED");
            paymentRepository.save(payment);
            return ResponseEntity.ok(new PaymentResponse("FAILED", "Simulated failure"));
        }

        // Success case
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);

        return ResponseEntity.ok(new PaymentResponse("SUCCESS", "Payment instruction accepted"));
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
	
}
