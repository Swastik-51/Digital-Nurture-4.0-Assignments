package com.cognizant.spring_learn.controller;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;




@RestController
public class AuthenticationController {

    private final String SECRET_KEY = "jwt_secret_key";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(HttpServletRequest request) {
        System.out.println("➡️  /authenticate endpoint hit");

        String authHeader = request.getHeader("Authorization");
        System.out.println("🔐 Auth Header: " + authHeader);

        // Safeguard for missing Authorization header
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        String decoded = new String(Base64.getDecoder().decode(base64Credentials));
        String[] credentials = decoded.split(":", 2);

        if (credentials.length != 2) {
            throw new RuntimeException("Malformed credentials");
        }

        String username = credentials[0];
        String password = credentials[1];

        System.out.println("✅ Username: " + username);
        System.out.println("✅ Password: " + password);

        if ("user".equals(username) && "pwd".equals(password)) {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 600000)) // 10 minutes
                    .signWith(SignatureAlgorithm.HS256, "jwt_secret_key")
                    .compact();

            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            return tokenMap;
        } else {
            throw new RuntimeException("Invalid Credentials");
        }

    }
    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Map<String, String>> handleAllExceptions(Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
