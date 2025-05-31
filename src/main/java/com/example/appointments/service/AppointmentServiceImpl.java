package com.example.appointments.service;

import com.example.appointments.dto.AppointmentDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Default implementation of AppointmentService.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<AppointmentDto> getAllAppointments() {
        // Return a static list for scaffolding
        return Collections.emptyList();
    }
}
