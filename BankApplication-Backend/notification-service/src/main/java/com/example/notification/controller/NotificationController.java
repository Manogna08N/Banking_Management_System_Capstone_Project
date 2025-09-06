package com.example.notification.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificationservice.dto.KycDecisionNotificationRequest;
import com.example.notificationservice.dto.TransferCompletedNotificationRequest;
import com.example.notificationservice.service.NotificationService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/notifications")
public class NotificationController {
	private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/transfer-completed")
    public ResponseEntity<?> transferCompleted(@Valid @RequestBody TransferCompletedNotificationRequest req) {
        Long id = service.notifyTransferCompleted(req);
        return ResponseEntity.ok(Map.of("deliveryId", id, "status", "OK"));
    }

    @PostMapping("/kyc-decision")
    public ResponseEntity<?> kycDecision(@Valid @RequestBody KycDecisionNotificationRequest req) {
        Long id = service.notifyKycDecision(req);
        return ResponseEntity.ok(Map.of("deliveryId", id, "status", "OK"));
    }
	

}
