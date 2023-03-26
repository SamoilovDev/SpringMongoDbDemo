package com.example.springclouddeno.controller;

import com.example.springclouddeno.domain.Health;
import com.example.springclouddeno.domain.HealthStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class HealthResource {

    @GetMapping(value = "/health", produces = "application/json")
    public ResponseEntity<Health> getHealth() {
        log.debug("REST request to get the Health Status");
        return ResponseEntity.ok(
                Health.builder()
                        .status(HealthStatus.UP)
                        .build()
        );
    }

}