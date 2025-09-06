package com.example.customerservice.security;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component

public class AuthClient {
	private final RestTemplate rt = new RestTemplate();

    public String requireRole(String token, String requiredRole) {
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        String t = token.substring(7);

        ResponseEntity<Map<String, Object>> resp = rt.exchange(
                "http://localhost:8080/auth/validate?token=" + t,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {}
        );

        Map<String, Object> body = resp.getBody();

        boolean valid = body != null && Boolean.TRUE.equals(body.get("valid"));
        String role = body != null ? (String) body.get("role") : null;

        if (!valid || role == null || !role.equals(requiredRole)) {
            return null;
        }

        return (String) body.get("email");
    }
 }
