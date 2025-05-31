package com.example.appointments.controller;

import com.example.appointments.dto.AppointmentDto;
import com.example.appointments.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing appointments.
 */
@RestController
@RequestMapping("/appointments")
@Tag(name = "Appointments", description = "API for managing appointments")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {

    private final AppointmentService appointmentService;

    /**
     * Get all appointments.
     * @return list of appointments
     */
    @Operation(summary = "Get all appointments", responses = {
            @ApiResponse(responseCode = "200", description = "List of appointments returned successfully")
    })
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        log.info("Fetching all appointments");
        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}
