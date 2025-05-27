package com.vha.sb.controller;

import com.vha.sb.dto.AppointmentDTO;
import com.vha.sb.service.AppointmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{patientId}")
    public List<AppointmentDTO> getLast10Appointments(@PathVariable String patientId) {
        return appointmentService.getLast10Appointments(patientId);
    }
}
