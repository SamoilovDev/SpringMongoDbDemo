package com.example.springclouddemo.controller;

import com.example.springclouddemo.domain.Health;
import com.example.springclouddemo.domain.HealthStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class HealthController {

    private static final HealthStatus HEALTH_STATUS = HealthStatus.UP;

    @Operation(summary = "Checking health status of the API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "API is working well!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Health.class)) }),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content),
            @ApiResponse(responseCode = "502", description = "API isn't working correctly!",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Health.class)) })
    })
    @GetMapping(value = "/health", produces = "application/json")
    public ResponseEntity<Health> getHealth() {
        log.debug("REST request to get the Health Status");
        return ResponseEntity.status(HEALTH_STATUS.getHttpStatus())
                .body(Health.builder().status(HEALTH_STATUS).build());
    }

}
